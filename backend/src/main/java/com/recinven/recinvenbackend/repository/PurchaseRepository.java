package com.recinven.recinvenbackend.repository;

import com.recinven.recinvenbackend.entity.Material;
import com.recinven.recinvenbackend.entity.Purchase;
import com.recinven.recinvenbackend.entity.User;
import com.recinven.recinvenbackend.entity.idclass.PurchaseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository extends JpaRepository<Purchase, PurchaseId> {
    @Query("SELECT purchase FROM Purchase purchase WHERE purchase.material.user = :user AND purchase.transactionId = :transactionId")
    Optional<List<Purchase>> findAllByUserAndTransactionId(@Param("User")User user, @Param("transactionId") Long transactionId);
    Optional<List<Purchase>> findAllByMaterial(Material material);
}
