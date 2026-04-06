package com.symphony.symphony_lite_api.controller;

import com.symphony.symphony_lite_api.dto.CreateUserRequest;
import com.symphony.symphony_lite_api.dto.UserResponse;
import com.symphony.symphony_lite_api.model.User;
import com.symphony.symphony_lite_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    // Delega responsabilidades (No hay lógica, valida inputs)

    private final UserService userService;

    @PostMapping
    public UserResponse createUser(@RequestBody @Validated CreateUserRequest request) {
        return userService.createUser(request);
    }
}