package com.military.english.service.impl;

import com.military.english.entity.User;
import com.military.english.mapper.UserMapper;
import com.military.english.model.LoginRequest;
import com.military.english.model.UserDto;
import com.military.english.repository.UserRepository;
import com.military.english.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto login(LoginRequest request) {
        // Tìm user theo username
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Tài khoản không tồn tại"));

        // So sánh password (plain text - sau này tích hợp BCrypt)
        if (!user.getPasswordHash().equals(request.getPassword())) {
            throw new RuntimeException("Sai mật khẩu");
        }

        // Trả về UserDto (kèm Role & Level) để Frontend phân luồng
        return userMapper.toDto(user);
    }
}
