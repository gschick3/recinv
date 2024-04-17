package com.recinven.recinvenbackend.assembler;

import com.recinven.recinvenbackend.controller.MaterialController;
import com.recinven.recinvenbackend.entity.Material;
import lombok.NonNull;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MaterialModelAssembler implements RepresentationModelAssembler<Material, EntityModel<Material>> {

    @Override
    public EntityModel<Material> toModel(@NonNull Material material) {
        return EntityModel.of(material,
                linkTo(methodOn(MaterialController.class).one(material.getUser().getUserId(), material.getMaterialId())).withSelfRel(),
                linkTo(methodOn(MaterialController.class).all(material.getUser().getUserId())).withRel("material"));
    }
}