package com.recinven.recinvenbackend.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class UserDto {
    private Long userId;
    public String email;
    public String name;
    public String phone;
    public String dateFormat;
    public String passHash;
}
