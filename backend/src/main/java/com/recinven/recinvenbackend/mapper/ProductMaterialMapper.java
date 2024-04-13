package com.recinven.recinvenbackend.mapper;

import com.recinven.recinvenbackend.dto.ProductMaterialDto;
import com.recinven.recinvenbackend.entity.ProductMaterial;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMaterialMapper extends GenericMapper<ProductMaterialDto, ProductMaterial> {
}
