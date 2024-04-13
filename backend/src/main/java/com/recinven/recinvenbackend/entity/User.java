package com.recinven.recinvenbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // stop from displaying in JSON responses
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Product> products;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Material> materials;

    @Override
    public String toString() {
        return String.format("Required: email [%s], name [%s], password (hidden) | Optional: phone: [%s], dateFormat: [%s]", email, name, phone, dateFormat);
    }
}

