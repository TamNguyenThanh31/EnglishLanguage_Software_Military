package com.military.english.mapper;

import com.military.english.entity.User;
import com.military.english.model.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
}
