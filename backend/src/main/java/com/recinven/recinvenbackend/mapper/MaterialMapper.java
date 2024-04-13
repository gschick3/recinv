package com.recinven.recinvenbackend.mapper;

import com.recinven.recinvenbackend.dto.MaterialDto;
import com.recinven.recinvenbackend.entity.Material;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaterialMapper extends GenericMapper<MaterialDto, Material> {
}