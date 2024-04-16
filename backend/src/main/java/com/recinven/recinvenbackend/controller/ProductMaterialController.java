package com.recinven.recinvenbackend.controller;

import com.recinven.recinvenbackend.assembler.ProductMaterialModelAssembler;
import com.recinven.recinvenbackend.dto.ProductMaterialDto;
import com.recinven.recinvenbackend.entity.ProductMaterial;
import com.recinven.recinvenbackend.service.ProductMaterialService;
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
@RequestMapping(path = "/users/{userId}/recipes", params = "productId")
public class ProductMaterialController {
    private final ProductMaterialModelAssembler productMaterialModelAssembler;
    private final ProductMaterialService productMaterialService;

    @Autowired
    public ProductMaterialController(ProductMaterialModelAssembler productMaterialModelAssembler, ProductMaterialService productMaterialService) {
        this.productMaterialModelAssembler = productMaterialModelAssembler;
        this.productMaterialService = productMaterialService;
    }

    @GetMapping
    public ResponseEntity<?> productAll(@PathVariable Long userId, @RequestParam Long productId) {
        List<EntityModel<ProductMaterial>> productMaterials = productMaterialService.findAllByProduct(userId, productId)
                .stream()
                .map(productMaterialModelAssembler::toModel)
                .toList();
        return ResponseEntity.ok(CollectionModel.of(productMaterials, linkTo(methodOn(ProductMaterialController.class).productAll(userId, productId)).withSelfRel()));
    }

    @GetMapping(params = "materialId")
    public ResponseEntity<?> one(@PathVariable Long userId, @RequestParam Long productId, @RequestParam Long materialId) {
        ProductMaterial productMaterial = productMaterialService.findById(userId, productId, materialId);

        return ResponseEntity.ok(productMaterialModelAssembler.toModel(productMaterial));
    }

    @PostMapping(path = "/new", params = "materialId")
    public ResponseEntity<?> create(@PathVariable Long userId, @RequestParam Long productId, @RequestParam Long materialId, @RequestBody ProductMaterial productMaterial) {
        EntityModel<ProductMaterial> productMaterialEntityModel = productMaterialModelAssembler.toModel(productMaterialService.create(userId, productId, materialId, productMaterial));
        return ResponseEntity.created(productMaterialEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(productMaterialEntityModel);
    }

    @PutMapping(params = "materialId")
    public ResponseEntity<?> update(@PathVariable Long userId, @RequestParam Long productId, @RequestParam Long materialId, @RequestBody ProductMaterialDto productMaterialDto) {
        ProductMaterial updatedProductMaterial = productMaterialService.updateById(userId, productId, materialId, productMaterialDto);

        EntityModel<ProductMaterial> productMaterialEntityModel = productMaterialModelAssembler.toModel(updatedProductMaterial);
        return ResponseEntity.created(productMaterialEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(productMaterialEntityModel);
    }

    @DeleteMapping(params = "materialId")
    public ResponseEntity<?> delete(@PathVariable Long userId, @RequestParam Long productId, @RequestParam Long materialId) {
        productMaterialService.deleteById(userId, productId, materialId);

        return ResponseEntity.noContent().build();
    }
}
