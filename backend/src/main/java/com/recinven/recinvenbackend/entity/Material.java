package com.recinven.recinvenbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "materials")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_id")
    private Long materialId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "current_quantity")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int currentQuantity;

    @Column(name = "unit")
    private String unit;

    @Column(name = "current_cost", nullable = false)
    private float currentCost;

    @Column(name = "total_purchased")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int totalPurchased;

    @Column(name = "total_spent")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private float totalSpent;
}
