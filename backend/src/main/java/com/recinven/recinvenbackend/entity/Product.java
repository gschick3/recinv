package com.recinven.recinvenbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "current_price", nullable = false)
    private double currentPrice;

    @Column(name = "total_sold")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int totalSold;

    @Column(name = "total_earned")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private double totalEarned;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ProductMaterial> productMaterials;
}
