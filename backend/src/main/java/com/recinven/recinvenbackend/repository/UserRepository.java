package com.recinven.recinvenbackend.repository;

import com.recinven.recinvenbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
