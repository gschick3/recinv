package com.recinven.recinvenbackend.mapper;

import com.recinven.recinvenbackend.dto.ProductDto;
import com.recinven.recinvenbackend.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends GenericMapper<ProductDto, Product> {
}