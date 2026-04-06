package com.symphony.symphony_lite_api.service;

import com.symphony.symphony_lite_api.dto.CreateUserRequest;
import com.symphony.symphony_lite_api.dto.UserResponse;
import com.symphony.symphony_lite_api.model.User;
import com.symphony.symphony_lite_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    // lógica de negocio
    // validaciones reales y reglas de negocio

    private final UserRepository userRepository;

    public UserResponse createUser(CreateUserRequest request) {
        userRepository.findByEmail(request.getEmail())
                .ifPresent(user -> {
                    throw new RuntimeException("User with email " + request.getEmail() + " already exists");
                });

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .build();

        User savedUser = userRepository.save(user);

        return UserResponse.builder()
                .id(savedUser.getId())
                .username(savedUser.getUsername())
                .email(savedUser.getEmail())
                .build();
    }
}
