package com.recinven.recinvenbackend.exceptions.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Class<?> c, Long id) {
        super(String.format("Could not find %s id: %d", c.getSimpleName(), id));
    }

    public EntityNotFoundException(Class<?> c, String id) {
        super(String.format("Could not find %s id: %s", c.getSimpleName(), id));
    }
}