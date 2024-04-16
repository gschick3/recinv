package com.recinven.recinvenbackend.repository;

import com.recinven.recinvenbackend.entity.Product;
import com.recinven.recinvenbackend.entity.Sale;
import com.recinven.recinvenbackend.entity.User;
import com.recinven.recinvenbackend.entity.idclass.SaleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SaleRepository extends JpaRepository<Sale, SaleId> {
    @Query("SELECT sale FROM Sale sale WHERE sale.product.user = :user AND sale.transactionId = :transactionId")
    Optional<List<Sale>> findAllByUserAndTransactionId(@Param("user") User user, @Param("transactionId") Long transactionId);
    Optional<List<Sale>> findAllByProduct(Product product);
}
