package com.recinven.recinvenbackend.service;

import com.recinven.recinvenbackend.dto.ProductMaterialDto;
import com.recinven.recinvenbackend.entity.Material;
import com.recinven.recinvenbackend.entity.Product;
import com.recinven.recinvenbackend.entity.ProductMaterial;
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
        return productMaterialRepository.findAllByProduct(product).orElseThrow(() -> new EntityNotFoundException(ProductMaterial.class, productId));
    }

    public List<ProductMaterial> findAllByMaterial(Long userId, Long materialId) {
        Material material = materialService.findById(userId, materialId);
        return productMaterialRepository.findAllByMaterial(material).orElseThrow(() -> new EntityNotFoundException(ProductMaterial.class, materialId));
    }

    public ProductMaterial findById(Long userId, Long productId,  Long materialId) {
        Product product = productService.findById(userId, productId);
        Material material = materialService.findById(userId, materialId);

        return productMaterialRepository.findById(new ProductMaterialId(product, material))
                .orElseThrow(() -> new EntityNotFoundException(ProductMaterial.class, String.format("%d %d", productId, materialId)));
    }

    @Transactional
    public ProductMaterial updateById(Long userId, Long productId, Long materialId, ProductMaterialDto productMaterialDto) {
        Product product = productService.findById(userId, productId);
        Material material = materialService.findById(userId, materialId);

        return productMaterialRepository.findById(new ProductMaterialId(product, material))
                .map(productMaterial -> {
                    productMaterialMapper.updateFromDto(productMaterialDto, productMaterial);
                    return productMaterialRepository.save(productMaterial);
                })
                .orElseThrow(() -> new EntityNotFoundException(ProductMaterial.class, String.format("%d %d", productId, materialId)));
    }

    public void deleteById(Long userId, Long productId, Long materialId) {
        Product product = productService.findById(userId, productId);
        Material material = materialService.findById(userId, materialId);
        ProductMaterialId productMaterialId = new ProductMaterialId(product, material);

        if (productMaterialRepository.findById(productMaterialId).isEmpty()) {
            throw new EntityNotFoundException(ProductMaterial.class, String.format("%d %d", productId, materialId));
        }

        productMaterialRepository.deleteById(productMaterialId);
    }

    @Transactional
    public ProductMaterial create(Long userId, Long productId, Long materialId, ProductMaterial productMaterial) {
        productMaterial.setProduct(productService.findById(userId, productId));
        productMaterial.setMaterial(materialService.findById(userId, materialId));

        return productMaterialRepository.save(productMaterial);
    }
}
