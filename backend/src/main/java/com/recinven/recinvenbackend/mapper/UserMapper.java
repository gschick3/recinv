package com.recinven.recinvenbackend.mapper;

import com.recinven.recinvenbackend.dto.UserDto;
import com.recinven.recinvenbackend.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<UserDto, User> {
}