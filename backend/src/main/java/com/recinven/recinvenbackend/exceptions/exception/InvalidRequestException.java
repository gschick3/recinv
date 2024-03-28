package com.recinven.recinvenbackend.exceptions.exception;

import com.recinven.recinvenbackend.dto.UserDto;
import com.recinven.recinvenbackend.entity.User;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(UserDto dto) {
        super("Invalid request: " + dto.toString());
    }

    public InvalidRequestException(User user) {
        super("Invalid request: " + user.toString());
    }
}
