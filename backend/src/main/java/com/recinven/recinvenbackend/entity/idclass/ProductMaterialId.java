package com.recinven.recinvenbackend.entity.idclass;

import com.recinven.recinvenbackend.entity.Material;
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
public final class ProductMaterialId implements Serializable {
    private final Product product;
    private final Material material;

    public ProductMaterialId() {
        this.product = new Product();
        this.material = new Material();
    }

    public ProductMaterialId(Product product, Material material) {
        this.product = product;
        this.material = material;
    }
}
