package com.recinven.recinvenbackend.mapper;

import com.recinven.recinvenbackend.dto.SaleDto;
import com.recinven.recinvenbackend.entity.Sale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleMapper extends GenericMapper<SaleDto, Sale> {
}
