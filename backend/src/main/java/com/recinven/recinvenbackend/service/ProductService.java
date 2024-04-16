package com.recinven.recinvenbackend.service;

import com.recinven.recinvenbackend.dto.ProductDto;
import com.recinven.recinvenbackend.entity.Product;
import com.recinven.recinvenbackend.entity.User;
import com.recinven.recinvenbackend.exceptions.exception.EntityNotFoundException;
import com.recinven.recinvenbackend.mapper.ProductMapper;
import com.recinven.recinvenbackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final UserService userService;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper, UserService userService) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.userService = userService;
    }

    public List<Product> findAll(Long userId) {
        User user = userService.findById(userId);
        return productRepository.findAllByUser(user).orElseThrow(() -> new EntityNotFoundException(Product.class, user.getUserId()));
    }

    public Product findById(Long userId, Long productId) {
        User user = userService.findById(userId);
        return productRepository.findByUserAndProductId(user, productId).orElseThrow(() -> new EntityNotFoundException(Product.class, productId));
    }

    @Transactional
    public Product updateById(Long userId, Long productId, ProductDto productDto) {
        User user = userService.findById(userId);
        return productRepository.findByUserAndProductId(user, productId)
                .map(product -> {
                    productMapper.updateFromDto(productDto, product);
                    return productRepository.save(product);
                })
                .orElseThrow(() -> new EntityNotFoundException(Product.class, productId));
    }

    public void deleteById(Long userId, Long productId) {
        User user = userService.findById(userId);
        if (productRepository.findByUserAndProductId(user, productId).isEmpty()) {
            throw new EntityNotFoundException(Product.class, productId);
        }

        productRepository.deleteById(productId);
    }

    @Transactional
    public Product create(Long userId, Product product) {
        User user = userService.findById(userId);
        product.setUser(user);
        return productRepository.save(product);
    }

    public boolean existsByDescription(Product product) {
        return product.getUser() != null && product.getDescription() != null
                && productRepository.existsByUserAndDescription(product.getUser(), product.getDescription());
    }
}
