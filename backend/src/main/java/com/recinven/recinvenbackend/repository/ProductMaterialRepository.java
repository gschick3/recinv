package com.recinven.recinvenbackend.repository;

import com.recinven.recinvenbackend.entity.Material;
import com.recinven.recinvenbackend.entity.Product;
import com.recinven.recinvenbackend.entity.ProductMaterial;
import com.recinven.recinvenbackend.entity.idclass.ProductMaterialId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductMaterialRepository extends JpaRepository<ProductMaterial, ProductMaterialId> {
    Optional<List<ProductMaterial>> findAllByProduct(Product product);
    Optional<List<ProductMaterial>> findAllByMaterial(Material material);
}
