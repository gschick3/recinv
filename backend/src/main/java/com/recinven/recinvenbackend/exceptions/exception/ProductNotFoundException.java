package com.recinven.recinvenbackend.exceptions.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long productId) {
        super("Could not find product " + productId);
    }
}
