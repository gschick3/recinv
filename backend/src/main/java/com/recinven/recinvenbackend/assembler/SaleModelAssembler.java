package com.recinven.recinvenbackend.assembler;

import com.recinven.recinvenbackend.controller.SaleController;
import com.recinven.recinvenbackend.entity.Sale;
import lombok.NonNull;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SaleModelAssembler implements RepresentationModelAssembler<Sale, EntityModel<Sale>> {
    @Override
    public EntityModel<Sale> toModel(@NonNull Sale sale) {
        return EntityModel.of(sale,
                linkTo(methodOn(SaleController.class).one(sale.getProduct().getUser().getUserId(), sale.getTransactionId(), sale.getProduct().getProductId())).withSelfRel(),
                linkTo(methodOn(SaleController.class).all(sale.getProduct().getUser().getUserId(), sale.getTransactionId())).withRel("sale"));
    }
}
