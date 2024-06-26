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
@Table(name = "materials")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_id")
    private Long materialId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "current_quantity")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private double currentQuantity;

    @Column(name = "unit", nullable = false)
    private String unit;

    @Column(name = "current_cost", nullable = false)
    private double currentCost;

    @Column(name = "total_purchased")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private double totalPurchased;

    @Column(name = "total_spent")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private double totalSpent;

    @OneToMany(mappedBy = "material", cascade = CascadeType.ALL, targetEntity = ProductMaterial.class, fetch = FetchType.EAGER)
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Set<ProductMaterial> productMaterials;

    public void makeSale(double quantityUsed) {
        currentQuantity -= quantityUsed;
    }

    public void makePurchase(double quantityPurchased) {
        makePurchase(quantityPurchased, currentCost);
    }

    public void makePurchase(double quantityPurchased, double unitCost) {
        currentQuantity += quantityPurchased;
        totalPurchased += quantityPurchased;
        totalSpent += quantityPurchased * unitCost;
    }
}
