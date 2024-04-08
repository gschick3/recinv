package com.recinven.recinvenbackend.repository;

import com.recinven.recinvenbackend.entity.Product;
import com.recinven.recinvenbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByUserAndProductId(User user, Long productId);
    Optional<List<Product>> findAllByUser(User user);

    Boolean existsByUserAndDescription(User user, String description);
}
