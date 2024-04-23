package com.recinven.recinvenbackend.mapper;

import com.recinven.recinvenbackend.dto.PurchaseDto;
import com.recinven.recinvenbackend.entity.Purchase;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PurchaseMapper extends GenericMapper<PurchaseDto, Purchase> {
}
