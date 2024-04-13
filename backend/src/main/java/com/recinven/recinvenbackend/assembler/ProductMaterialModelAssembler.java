package com.recinven.recinvenbackend.assembler;

import com.recinven.recinvenbackend.controller.ProductMaterialController;
import com.recinven.recinvenbackend.entity.ProductMaterial;
import lombok.NonNull;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductMaterialModelAssembler implements RepresentationModelAssembler<ProductMaterial, EntityModel<ProductMaterial>> {
    @Override
    public EntityModel<ProductMaterial> toModel(@NonNull ProductMaterial productMaterial) {
        Long userId = productMaterial.getProduct().getUser().getUserId();
        return EntityModel.of(productMaterial,
                linkTo(methodOn(ProductMaterialController.class).one(userId, productMaterial.getProduct().getProductId(), productMaterial.getMaterial().getMaterialId())).withSelfRel(),
                linkTo(methodOn(ProductMaterialController.class).all(userId, productMaterial.getProduct().getProductId())).withRel("productMaterial"));
    }
}
