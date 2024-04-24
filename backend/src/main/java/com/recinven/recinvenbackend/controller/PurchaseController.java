package com.recinven.recinvenbackend.controller;

import com.recinven.recinvenbackend.assembler.PurchaseModelAssembler;
import com.recinven.recinvenbackend.dto.PurchaseDto;
import com.recinven.recinvenbackend.entity.Purchase;
import com.recinven.recinvenbackend.service.PurchaseService;
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
@RequestMapping(path = "/users/{userId}/purchases")
public class PurchaseController {
    private final PurchaseModelAssembler purchaseModelAssembler;
    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseModelAssembler purchaseModelAssembler, PurchaseService purchaseService) {
        this.purchaseModelAssembler = purchaseModelAssembler;
        this.purchaseService = purchaseService;
    }

    @GetMapping(params = "transactionId")
    public ResponseEntity<?> all(@PathVariable Long userId, @RequestParam Long transactionId) {
        List<EntityModel<Purchase>> purchases = purchaseService.findAllByTransaction(userId, transactionId)
                .stream()
                .map(purchaseModelAssembler::toModel)
                .toList();

        return ResponseEntity.ok(CollectionModel.of(purchases, linkTo(methodOn(PurchaseController.class).all(userId, transactionId)).withSelfRel()));
    }

    @GetMapping(params = {"transactionId", "materialId"})
    public ResponseEntity<?> one(@PathVariable Long userId, @RequestParam Long transactionId, @RequestParam Long materialId) {
        Purchase purchase = purchaseService.findById(userId, transactionId, materialId);

        return ResponseEntity.ok(purchaseModelAssembler.toModel(purchase));
    }

    @PostMapping(path = "/new", params = "materialId")
    public ResponseEntity<?> create(@PathVariable Long userId, @RequestParam Long materialId, @RequestBody Purchase purchase) {
        EntityModel<Purchase> purchaseEntityModel = purchaseModelAssembler.toModel(purchaseService.create(userId, materialId, purchase));

        return ResponseEntity.created(purchaseEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(purchaseEntityModel);
    }

    @PutMapping(params = {"transactionId", "materialId"})
    public ResponseEntity<?> update(@PathVariable Long userId, @RequestParam Long transactionId, @RequestParam Long materialId, @RequestBody PurchaseDto purchaseDto) {
        Purchase updatedPurchase = purchaseService.updateById(userId, transactionId, materialId, purchaseDto);

        EntityModel<Purchase> purchaseEntityModel = purchaseModelAssembler.toModel(updatedPurchase);
        return ResponseEntity.created(purchaseEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(purchaseEntityModel);
    }

    @DeleteMapping(params = {"transactionId", "materialId"})
    public ResponseEntity<?> delete(@PathVariable Long userId, @RequestParam Long transactionId, @RequestParam Long materialId) {
        purchaseService.deleteById(userId, transactionId, materialId);

        return ResponseEntity.noContent().build();
    }
}
