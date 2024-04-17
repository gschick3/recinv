package com.recinven.recinvenbackend.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

public interface GenericMapper<DtoType, ClassType> {
    @BeanMapping(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(DtoType materialDto, @MappingTarget ClassType material);
}
