package com.military.english.service;

import com.military.english.model.LoginRequest;
import com.military.english.model.UserDto;

public interface AuthService {
    UserDto login(LoginRequest request);
}
