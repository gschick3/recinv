package com.recinven.recinvenbackend.assembler;

import com.recinven.recinvenbackend.controller.PurchaseController;
import com.recinven.recinvenbackend.entity.Purchase;
import lombok.NonNull;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PurchaseModelAssembler implements RepresentationModelAssembler<Purchase, EntityModel<Purchase>> {
    @Override
    public EntityModel<Purchase> toModel(@NonNull Purchase purchase) {
        return EntityModel.of(purchase,
                linkTo(methodOn(PurchaseController.class).one(purchase.getMaterial().getUser().getUserId(), purchase.getTransactionId(), purchase.getMaterial().getMaterialId())).withSelfRel(),
                linkTo(methodOn(PurchaseController.class).all(purchase.getMaterial().getUser().getUserId(), purchase.getTransactionId())).withRel("purchase"));
    }
}
