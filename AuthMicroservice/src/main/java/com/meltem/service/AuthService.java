package com.meltem.service;

import com.meltem.dto.request.CreateUserRequestDto;
import com.meltem.dto.request.RegisterRequestDto;
import com.meltem.dto.response.LoginResponseDto;
import com.meltem.entity.Auth;
import com.meltem.manager.UserProfileManager;
import com.meltem.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository repository;
    private final UserProfileManager userProfileManager;

    public Auth register(RegisterRequestDto dto) {
        Auth auth = repository.save(Auth.builder()
                .userName(dto.getUserName())
                .email(dto.getEmail())
                .password(dto.getRepassword())
                .build());
        userProfileManager.createUser(CreateUserRequestDto.builder()
                .authId(auth.getId())
                .email(auth.getEmail())
                .username(auth.getUserName())
                .build());
        return auth;
    }

    public Boolean login(LoginResponseDto dto) {
        return repository.existsByUserNameAndPassword(dto.getUserName(), dto.getPassword());
    }
}
