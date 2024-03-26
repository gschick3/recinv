package com.recinven.recinvenbackend.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "phone", unique = true)
    private String phone;
    @Column(name = "date_format", length = 10)
    private String dateFormat;
    @Column(name = "pass_hash", nullable = false)
    private String password;

    public User() {}

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void setPassword(String passHash) {
        // Do hashing here?
        this.password = passHash;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User u)) {
            return false;
        }
        if (this == u) {
            return true;
        }
        return (Objects.equals(this.userId, u.userId));
    }

    @Override
    public String toString() {
        return String.format("Required: email [%s], name [%s], password (hidden) | Optional: phone: [%s], dateFormat: [%s]", email, name, phone, dateFormat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, email, name);
    }
}

