package com.recinven.recinvenbackend.controller;

import com.recinven.recinvenbackend.assembler.ProductModelAssembler;
import com.recinven.recinvenbackend.dto.ProductDto;
import com.recinven.recinvenbackend.entity.Product;
import com.recinven.recinvenbackend.service.ProductService;
import com.recinven.recinvenbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/users/{userId}/products")
public class ProductController {
    private final ProductModelAssembler productModelAssembler;
    private final ProductService productService;

    @Autowired
    public ProductController(ProductModelAssembler productModelAssembler, ProductService productService, UserService userService) {
        this.productModelAssembler = productModelAssembler;
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<?> all(@PathVariable Long userId) {
        List<EntityModel<Product>> products = productService.findAll(userId).stream()
                .map(productModelAssembler::toModel)
                .toList();
        return ResponseEntity.ok(CollectionModel.of(products, linkTo(methodOn(ProductController.class).all(userId)).withSelfRel()));
    }

    @GetMapping(params = "productId")
    public ResponseEntity<?> one(@PathVariable Long userId, @RequestParam Long productId) {
        Product product = productService.findById(userId, productId);

        return ResponseEntity.ok(productModelAssembler.toModel(product));
    }

    @PostMapping("/new")
    public ResponseEntity<?> create(@PathVariable Long userId, @RequestBody Product product) {
        if (productService.existsByDescription(product)) {
            return ResponseEntity.badRequest().body(String.format("User %d already has a product with description: %s", product.getUser().getUserId(), product.getDescription()));
        }

        EntityModel<Product> productEntityModel = productModelAssembler.toModel(productService.create(userId, product));
        return ResponseEntity.created(productEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(productEntityModel);
    }

    @PutMapping(params = "productId")
    public ResponseEntity<?> update(@PathVariable Long userId, @RequestParam Long productId, @RequestBody ProductDto productDto) {
        Product updatedProduct = productService.updateById(userId, productId, productDto);

        EntityModel<Product> productEntityModel = productModelAssembler.toModel(updatedProduct);
        return ResponseEntity.created(productEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(productEntityModel);
    }

    @DeleteMapping(params = "productId")
    public ResponseEntity<?> delete(@PathVariable Long userId, @RequestParam Long productId) {
        productService.deleteById(userId, productId);

        return ResponseEntity.noContent().build();
    }
}
