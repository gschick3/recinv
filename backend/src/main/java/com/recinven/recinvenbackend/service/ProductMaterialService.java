package com.recinven.recinvenbackend.service;

import com.recinven.recinvenbackend.dto.ProductMaterialDto;
import com.recinven.recinvenbackend.entity.Material;
import com.recinven.recinvenbackend.entity.Product;
import com.recinven.recinvenbackend.entity.ProductMaterial;
import com.recinven.recinvenbackend.entity.User;
import com.recinven.recinvenbackend.entity.idclass.ProductMaterialId;
import com.recinven.recinvenbackend.exceptions.exception.EntityNotFoundException;
import com.recinven.recinvenbackend.mapper.ProductMaterialMapper;
import com.recinven.recinvenbackend.repository.ProductMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductMaterialService {
    final ProductMaterialRepository productMaterialRepository;
    final ProductMaterialMapper productMaterialMapper;
    final UserService userService;
    final ProductService productService;
    final MaterialService materialService;

    @Autowired
    public ProductMaterialService(ProductMaterialRepository productMaterialRepository, ProductMaterialMapper productMaterialMapper, UserService userService, ProductService productService, MaterialService materialService) {
        this.productMaterialRepository = productMaterialRepository;
        this.productMaterialMapper = productMaterialMapper;
        this.userService = userService;
        this.productService = productService;
        this.materialService = materialService;
    }

    public List<ProductMaterial> findAllByProduct(Long userId, Long productId) {
        Product product = productService.findById(userId, productId);
        return productMaterialRepository.findAllByProduct(product).orElseThrow(() -> new EntityNotFoundException(User.class, userId));
    }

    public List<ProductMaterial> findAllByMaterial(Long userId, Long materialId) {
        Material material = materialService.findById(userId, materialId);
        return productMaterialRepository.findAllByMaterial(material).orElseThrow(() -> new EntityNotFoundException(User.class, userId));
    }

    public ProductMaterial findById(Long userId, ProductMaterialId productMaterialId) {
        Product product = productService.findById(userId, productMaterialId.getProduct().getProductId());
        Material material = materialService.findById(userId, productMaterialId.getMaterial().getMaterialId());

        return productMaterialRepository.findByProductAndMaterial(product, material).orElseThrow(() -> new EntityNotFoundException(Material.class, productMaterialId.toString()));
    }

    @Transactional
    public ProductMaterial updateById(Long userId, ProductMaterialId productMaterialId, ProductMaterialDto productMaterialDto) {
        Product product = productService.findById(userId, productMaterialId.getProduct().getProductId());
        Material material = materialService.findById(userId, productMaterialId.getMaterial().getMaterialId());

        return productMaterialRepository.findByProductAndMaterial(product, material)
                .map(productMaterial -> {
                    productMaterialMapper.updateFromDto(productMaterialDto, productMaterial);
                    return productMaterialRepository.save(productMaterial);
                })
                .orElseThrow(() -> new EntityNotFoundException(Material.class, productMaterialId.toString()));
    }

    public void deleteById(Long userId, ProductMaterialId productMaterialId) {
        Product product = productService.findById(userId, productMaterialId.getProduct().getProductId());
        Material material = materialService.findById(userId, productMaterialId.getMaterial().getMaterialId());

        if (productMaterialRepository.findByProductAndMaterial(product, material).isEmpty()) {
            throw new EntityNotFoundException(Material.class, productMaterialId.toString());
        }

        productMaterialRepository.deleteById(productMaterialId);
    }

    @Transactional
    public ProductMaterial create(ProductMaterial productMaterial) {
        return productMaterialRepository.save(productMaterial);
    }
}
