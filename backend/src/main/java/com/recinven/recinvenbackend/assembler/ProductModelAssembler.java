package com.recinven.recinvenbackend.assembler;

import com.recinven.recinvenbackend.controller.ProductController;
import com.recinven.recinvenbackend.entity.Product;
import lombok.NonNull;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductModelAssembler implements RepresentationModelAssembler<Product, EntityModel<Product>> {

    @Override
    public EntityModel<Product> toModel(@NonNull Product product) {
        return EntityModel.of(product,
                linkTo(methodOn(ProductController.class).one(product.getUser().getUserId(), product.getProductId())).withSelfRel(),
                linkTo(methodOn(ProductController.class).all(product.getUser().getUserId())).withRel("products"));
    }
}
