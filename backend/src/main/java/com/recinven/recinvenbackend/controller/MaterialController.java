package com.recinven.recinvenbackend.controller;

import com.recinven.recinvenbackend.assembler.MaterialModelAssembler;
import com.recinven.recinvenbackend.dto.MaterialDto;
import com.recinven.recinvenbackend.entity.Material;
import com.recinven.recinvenbackend.service.MaterialService;
import com.recinven.recinvenbackend.service.UserService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/users/{userId}/materials")
public class MaterialController {
    private final MaterialModelAssembler materialModelAssembler;
    private final MaterialService materialService;
    private final UserService userService;

    public MaterialController(MaterialModelAssembler materialModelAssembler, MaterialService materialService, UserService userService) {
        this.materialModelAssembler = materialModelAssembler;
        this.materialService = materialService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> all(@PathVariable Long userId) {
        List<EntityModel<Material>> materials = materialService.findAll(userId).stream()
                .map(materialModelAssembler::toModel)
                .toList();
        return ResponseEntity.ok(CollectionModel.of(materials, linkTo(methodOn(MaterialController.class).all(userId)).withSelfRel()));
    }

    @GetMapping(params = "materialId")
    public ResponseEntity<?> one(@PathVariable Long userId, @RequestParam Long materialId) {
        Material material = materialService.findById(userId, materialId);

        return ResponseEntity.ok(materialModelAssembler.toModel(material));
    }

    @PostMapping("/new")
    public ResponseEntity<?> create(@PathVariable Long userId, @RequestBody Material material) {
        material.setUser(userService.findById(userId));

        if (materialService.existsByBrandAndDescription(material)) {
            return ResponseEntity.badRequest().body(String.format("User %d already has a material with brand: %s and description: %s", material.getUser().getUserId(), material.getBrand(), material.getDescription()));
        }

        EntityModel<Material> materialEntityModel = materialModelAssembler.toModel(materialService.create(material));
        return ResponseEntity.created(materialEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(materialEntityModel);
    }

    @PutMapping(params = "materialId")
    public ResponseEntity<?> update(@PathVariable Long userId, @RequestParam Long materialId, @RequestBody MaterialDto materialDto) {
        Material updatedMaterial = materialService.updateById(userId, materialId, materialDto);

        EntityModel<Material> materialEntityModel = materialModelAssembler.toModel(updatedMaterial);
        return ResponseEntity.created(materialEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(materialEntityModel);
    }

    @DeleteMapping(params = "materialId")
    public ResponseEntity<?> delete(@PathVariable Long userId, @RequestParam Long materialId) {
        materialService.deleteById(userId, materialId);

        return ResponseEntity.noContent().build();
    }
}
