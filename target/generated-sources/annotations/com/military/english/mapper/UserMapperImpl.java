package com.military.english.mapper;

import com.military.english.entity.User;
import com.military.english.model.UserDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-31T21:26:56+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.200.v20261008-1115, environment: Java 25.0.4.1 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setUsername( user.getUsername() );
        userDto.setRole( user.getRole() );
        userDto.setLevel( user.getLevel() );
        userDto.setUnitName( user.getUnitName() );
        userDto.setCreatedAt( user.getCreatedAt() );

        return userDto;
    }
}
