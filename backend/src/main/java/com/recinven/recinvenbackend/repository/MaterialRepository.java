package com.recinven.recinvenbackend.repository;

import com.recinven.recinvenbackend.entity.Material;
import com.recinven.recinvenbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MaterialRepository extends JpaRepository<Material, Long> {
    Optional<Material> findByUserAndMaterialId(User user, Long productId);
    Optional<List<Material>> findAllByUser(User user);

    Boolean existsByUserAndBrandAndDescription(User user, String brand, String description);
}
