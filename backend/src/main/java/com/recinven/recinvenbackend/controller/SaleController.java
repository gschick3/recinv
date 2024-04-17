package com.recinven.recinvenbackend.controller;

import com.recinven.recinvenbackend.assembler.SaleModelAssembler;
import com.recinven.recinvenbackend.dto.SaleDto;
import com.recinven.recinvenbackend.entity.Sale;
import com.recinven.recinvenbackend.service.SaleService;
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
@RequestMapping(path = "/users/{userId}/sales")
public class SaleController {
    private final SaleModelAssembler saleModelAssembler;
    private final SaleService saleService;

    @Autowired
    public SaleController(SaleModelAssembler saleModelAssembler, SaleService saleService) {
        this.saleModelAssembler = saleModelAssembler;
        this.saleService = saleService;
    }

    @GetMapping(params = "transactionId")
    public ResponseEntity<?> all(@PathVariable Long userId, @RequestParam Long transactionId) {
        List<EntityModel<Sale>> sales = saleService.findAllByTransaction(userId, transactionId)
                .stream()
                .map(saleModelAssembler::toModel)
                .toList();

        return ResponseEntity.ok(CollectionModel.of(sales, linkTo(methodOn(SaleController.class).all(userId, transactionId)).withSelfRel()));
    }

    @GetMapping(params = {"transactionId", "productId"})
    public ResponseEntity<?> one(@PathVariable Long userId, @RequestParam Long transactionId, @RequestParam Long productId) {
        Sale sale = saleService.findById(userId, transactionId, productId);

        return ResponseEntity.ok(saleModelAssembler.toModel(sale));
    }

    @PostMapping(path = "/new", params = "productId")
    public ResponseEntity<?> create(@PathVariable Long userId, @RequestParam Long productId, @RequestBody Sale sale) {
        EntityModel<Sale> saleEntityModel = saleModelAssembler.toModel(saleService.create(userId, productId, sale));

        return ResponseEntity.created(saleEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(saleEntityModel);
    }

    @PutMapping(params = {"transactionId", "productId"})
    public ResponseEntity<?> update(@PathVariable Long userId, @RequestParam Long transactionId, @RequestParam Long productId, @RequestBody SaleDto saleDto) {
        Sale updatedSale = saleService.updateById(userId, transactionId, productId, saleDto);

        EntityModel<Sale> saleEntityModel = saleModelAssembler.toModel(updatedSale);
        return ResponseEntity.created(saleEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(saleEntityModel);
    }

    @DeleteMapping(params = {"transactionId", "productId"})
    public ResponseEntity<?> delete(@PathVariable Long userId, @RequestParam Long transactionId, @RequestParam Long productId) {
        saleService.deleteById(userId, transactionId, productId);

        return ResponseEntity.noContent().build();
    }
}
