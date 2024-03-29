package com.recinven.recinvenbackend.repository;

import com.recinven.recinvenbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    User findByPhone(String phone);

    Boolean existsByEmail(String email);

    Boolean existsByPhone(String phone);
}
