package com.recinven.recinvenbackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recinven.recinvenbackend.entity.idclass.SaleId;
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
@IdClass(SaleId.class)
@Table(name = "sales")
public class Sale {
    @Id
    @Column(name = "transaction_id", nullable = false)
    private Long transactionId;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Product product = new Product();

    @Column(name = "quantity_sold", nullable = false)
    private int quantitySold;

    @Column(name = "unit_cost")
    private double unitCost;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "date", nullable = false)
    private Date date;
}
