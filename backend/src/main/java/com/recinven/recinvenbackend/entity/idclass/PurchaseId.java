package com.recinven.recinvenbackend.entity.idclass;

import com.recinven.recinvenbackend.entity.Material;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@EqualsAndHashCode
@ToString
@Getter
@Setter
public class PurchaseId implements Serializable {
    private final Long transactionId;
    private final Material material;

    public PurchaseId() {
        this.transactionId = 0L;
        this.material = new Material();
    }

    public PurchaseId(Long transactionId, Material material) {
        this.transactionId = transactionId;
        this.material = material;
    }
}
