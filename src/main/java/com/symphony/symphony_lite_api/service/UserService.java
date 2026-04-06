package com.symphony.symphony_lite_api.service;

import com.symphony.symphony_lite_api.model.User;
import com.symphony.symphony_lite_api.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }
}
