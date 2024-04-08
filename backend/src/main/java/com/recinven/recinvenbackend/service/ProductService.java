package com.recinven.recinvenbackend.service;

import com.recinven.recinvenbackend.dto.ProductDto;
import com.recinven.recinvenbackend.entity.Product;
import com.recinven.recinvenbackend.entity.User;
import com.recinven.recinvenbackend.exceptions.exception.ProductNotFoundException;
import com.recinven.recinvenbackend.exceptions.exception.UserNotFoundException;
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
        return productRepository.findAllByUser(user).orElseThrow(() -> new UserNotFoundException(userId));
    }

    public Product findById(Long userId, Long productId) {
        User user = userService.findById(userId);
        return productRepository.findByUserAndProductId(user, productId).orElseThrow(() -> new ProductNotFoundException(productId));
    }

    @Transactional
    public Product updateById(Long userId, Long productId, ProductDto productDto) {
        User user = userService.findById(userId);
        return productRepository.findByUserAndProductId(user, productId)
                .map(product -> {
                    productMapper.updateProductFromDto(productDto, product);
                    return productRepository.save(product);
                })
                .orElseThrow(() -> new ProductNotFoundException(productId));
    }

    public void deleteById(Long userId, Long productId) {
        User user = userService.findById(userId);
        if (productRepository.findByUserAndProductId(user, productId).isPresent()) {
            throw new ProductNotFoundException(productId);
        }

        productRepository.deleteById(productId);
    }

    @Transactional
    public Product create(Product product) {
        return productRepository.save(product);
    }

    public boolean existsByDescription(Product product) {
        return productRepository.existsByUserAndDescription(product.getUser(), product.getDescription());
    }
}
