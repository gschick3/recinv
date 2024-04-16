package com.recinven.recinvenbackend.entity.idclass;

import com.recinven.recinvenbackend.entity.Product;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@EqualsAndHashCode
@ToString
@Getter
@Setter
public class SaleId implements Serializable {
    private final Long transactionId;
    private final Product product;

    public SaleId() {
        this.transactionId = 0L;
        this.product = new Product();
    }

    public SaleId(Long transactionId, Product product) {
        this.transactionId = transactionId;
        this.product = product;
    }
}
