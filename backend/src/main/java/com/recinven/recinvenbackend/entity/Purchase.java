package com.recinven.recinvenbackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recinven.recinvenbackend.entity.idclass.PurchaseId;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Data
@IdClass(PurchaseId.class)
@Table(name = "purchases")
public class Purchase {
    @Id
    @Column(name = "transaction_id", nullable = false)
    private Long transactionId;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "material_id")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Material material = new Material();

    @Column(name = "quantity_purchased", nullable = false)
    private double quantityPurchased;

    @Column(name = "unit_cost")
    private double unitCost;

    @Column(name = "date")
    private Date date;

    public void calculateUnitCost() {
        unitCost = material.getCurrentCost();
    }
}
