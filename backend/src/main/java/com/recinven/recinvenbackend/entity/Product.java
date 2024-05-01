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
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @ManyToOne(fetch = FetchType.EAGER)
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

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, targetEntity = ProductMaterial.class, fetch = FetchType.EAGER)
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Set<ProductMaterial> productMaterials;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, targetEntity = Sale.class, fetch = FetchType.EAGER)
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Set<Sale> sales;

    public void makeSale(int numSold) {
        makeSale(numSold, currentPrice);
    }

    public void makeSale(int numSold, double unitPrice) {
        totalSold += numSold;
        totalEarned += numSold * unitPrice;
    }
}
