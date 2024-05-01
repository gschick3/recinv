package com.recinven.recinvenbackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recinven.recinvenbackend.entity.idclass.ProductMaterialId;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Data
@IdClass(ProductMaterialId.class)
@Table(name = "product_materials")
public class ProductMaterial {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Product product;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "material_id")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Material material;

    @Column(name = "amount", nullable = false)
    private double amount;
}
