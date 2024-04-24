package com.recinven.recinvenbackend.service;

import com.recinven.recinvenbackend.dto.PurchaseDto;
import com.recinven.recinvenbackend.entity.Material;
import com.recinven.recinvenbackend.entity.Purchase;
import com.recinven.recinvenbackend.entity.User;
import com.recinven.recinvenbackend.entity.idclass.PurchaseId;
import com.recinven.recinvenbackend.exceptions.exception.EntityNotFoundException;
import com.recinven.recinvenbackend.mapper.PurchaseMapper;
import com.recinven.recinvenbackend.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper purchaseMapper;
    private final MaterialService materialService;
    private final UserService userService;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository, PurchaseMapper purchaseMapper, MaterialService materialService, UserService userService) {
        this.purchaseRepository = purchaseRepository;
        this.purchaseMapper = purchaseMapper;
        this.materialService = materialService;
        this.userService = userService;
    }

    public List<Purchase> findAllByTransaction(Long userId, Long transactionId) {
        User user = userService.findById(userId);
        return purchaseRepository.findAllByUserAndTransactionId(user, transactionId).orElseThrow(() -> new EntityNotFoundException(Purchase.class, transactionId));
    }

    public List<Purchase> findAllByMaterial(Long userId, Long materialId) {
        Material material = materialService.findById(userId, materialId);
        return purchaseRepository.findAllByMaterial(material).orElseThrow(() -> new EntityNotFoundException(Purchase.class, materialId));
    }

    public Purchase findById(Long userId, Long transactionId, Long materialId) {
        Material material = materialService.findById(userId, materialId);
        return purchaseRepository.findById(new PurchaseId(transactionId, material)).orElseThrow(() -> new EntityNotFoundException(Purchase.class, String.format("%d %d", materialId, transactionId)));
    }

    @Transactional
    public Purchase updateById(Long userId, Long transactionId, Long materialId, PurchaseDto purchaseDto) {
        Material material = materialService.findById(userId, materialId);
        return purchaseRepository.findById(new PurchaseId(transactionId, material))
                .map(purchase -> {
                    double originalQuantityPurchased = purchase.getQuantityPurchased();
                    purchaseMapper.updateFromDto(purchaseDto, purchase);

                    Purchase result = purchaseRepository.save(purchase);

                    if (purchaseDto.quantityPurchased > 0) {
                        double difference = purchaseDto.quantityPurchased - originalQuantityPurchased;

                        result.getMaterial().makePurchase(difference, result.getUnitCost());
                        materialService.create(userId, result.getMaterial());
                    }

                    return result;
                }).orElseThrow(() -> new EntityNotFoundException(Purchase.class, String.format("%d %d", materialId, transactionId)));
    }

    public void deleteById(Long userId, Long transactionId, Long materialId) {
        Material material = materialService.findById(userId, materialId);
        PurchaseId purchaseId = new PurchaseId(transactionId, material);

        if (purchaseRepository.findById(purchaseId).isEmpty()) {
            throw new EntityNotFoundException(Purchase.class, String.format("%d %d", materialId, transactionId));
        }

        purchaseRepository.deleteById(purchaseId);
    }

    @Transactional
    public Purchase create(Long userId, Long materialId, Purchase purchase) {
        purchase.setMaterial(materialService.findById(userId, materialId));

        if (purchase.getUnitCost() == 0) {
            purchase.calculateUnitCost();
        }

        Purchase result = purchaseRepository.save(purchase);

        result.getMaterial().makePurchase(result.getQuantityPurchased(), result.getUnitCost());
        materialService.create(userId, result.getMaterial());

        return result;
    }
}
