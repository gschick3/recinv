package com.recinven.recinvenbackend.controller;

import com.recinven.recinvenbackend.assembler.ProductMaterialModelAssembler;
import com.recinven.recinvenbackend.dto.ProductMaterialDto;
import com.recinven.recinvenbackend.entity.Material;
import com.recinven.recinvenbackend.entity.Product;
import com.recinven.recinvenbackend.entity.ProductMaterial;
import com.recinven.recinvenbackend.entity.idclass.ProductMaterialId;
import com.recinven.recinvenbackend.service.MaterialService;
import com.recinven.recinvenbackend.service.ProductMaterialService;
import com.recinven.recinvenbackend.service.ProductService;
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
@RequestMapping(path = "/users/{userId}/products/{productId}/materials")
public class ProductMaterialController {
    private final ProductMaterialModelAssembler productMaterialModelAssembler;
    private final ProductMaterialService productMaterialService;
    private final ProductService productService;
    private final MaterialService materialService;

    @Autowired
    public ProductMaterialController(ProductMaterialModelAssembler productMaterialModelAssembler, ProductMaterialService productMaterialService, ProductService productService, MaterialService materialService) {
        this.productMaterialModelAssembler = productMaterialModelAssembler;
        this.productMaterialService = productMaterialService;
        this.productService = productService;
        this.materialService = materialService;
    }

    @GetMapping
    public ResponseEntity<?> all(@PathVariable Long userId, @PathVariable Long productId) {
        List<EntityModel<ProductMaterial>> productMaterials = productMaterialService.findAllByProduct(userId, productId)
                .stream()
                .map(productMaterialModelAssembler::toModel)
                .toList();
        return ResponseEntity.ok(CollectionModel.of(productMaterials, linkTo(methodOn(ProductMaterialController.class).all(userId, productId)).withSelfRel()));
    }

    @GetMapping("/{materialId}")
    public ResponseEntity<?> one(@PathVariable Long userId, @PathVariable Long productId, @PathVariable Long materialId) {
        Product product = productService.findById(userId, productId);
        Material material = materialService.findById(userId, materialId);

        ProductMaterial productMaterial = productMaterialService.findById(userId, new ProductMaterialId(product, material));

        return ResponseEntity.ok(productMaterialModelAssembler.toModel(productMaterial));
    }

    @PostMapping("/{materialId}")
    public ResponseEntity<?> create(@PathVariable Long userId, @PathVariable Long productId, @PathVariable Long materialId, @RequestBody ProductMaterial productMaterial) {
        productMaterial.setProduct(productService.findById(userId, productId));
        productMaterial.setMaterial(materialService.findById(userId, materialId));

        EntityModel<ProductMaterial> productMaterialEntityModel = productMaterialModelAssembler.toModel(productMaterialService.create(productMaterial));
        return ResponseEntity.created(productMaterialEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(productMaterialEntityModel);
    }

    @PutMapping("/{materialId}")
    public ResponseEntity<?> update(@PathVariable Long userId, @PathVariable Long productId, @PathVariable Long materialId, @RequestBody ProductMaterialDto productMaterialDto) {
        Product product = productService.findById(userId, productId);
        Material material = materialService.findById(userId, materialId);
        ProductMaterial updatedProductMaterial = productMaterialService.updateById(userId, new ProductMaterialId(product, material), productMaterialDto);

        EntityModel<ProductMaterial> productMaterialEntityModel = productMaterialModelAssembler.toModel(updatedProductMaterial);
        return ResponseEntity.created(productMaterialEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(productMaterialEntityModel);
    }

    @DeleteMapping("/{materialId}")
    public ResponseEntity<?> delete(@PathVariable Long userId, @PathVariable Long productId, @PathVariable Long materialId) {
        Product product = productService.findById(userId, productId);
        Material material = materialService.findById(userId, materialId);
        productMaterialService.deleteById(userId, new ProductMaterialId(product, material));

        return ResponseEntity.noContent().build();
    }
}
