package com.military.english.model;

import com.military.english.enums.Level;
import com.military.english.enums.Role;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {
    private Long id;
    private String username;
    private Role role;
    private Level level;
    private String unitName;
    private LocalDateTime createdAt;
}
