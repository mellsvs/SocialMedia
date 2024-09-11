package com.meltem.service;

import com.meltem.dto.request.RegisterRequestDto;
import com.meltem.dto.response.LoginResponseDto;
import com.meltem.entity.Auth;
import com.meltem.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository repository;

    public Auth register(RegisterRequestDto dto) {
     return repository.save(Auth.builder()
                        .userName(dto.getUserName())
                        .email(dto.getEmail())
                        .password(dto.getRepassword())
                .build());

    }

    public Boolean login(LoginResponseDto dto) {
        return repository.existsByUserNameAndPassword(dto.getUserName(),dto.getPassword());
    }
}
