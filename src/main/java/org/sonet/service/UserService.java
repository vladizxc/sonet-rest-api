package org.sonet.service;

import jakarta.transaction.Transactional;
import org.sonet.entity.User;
import org.sonet.entity.dto.userDto.UserDto;
import org.sonet.entity.request.CreateUserRequest;
import org.sonet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User getCurrentUser(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository
                .findByUsernameIgnoreCase(username)
                .orElseThrow(()->new IllegalArgumentException("User with username = " + username + " not found."));
    }

    public UserDto createUser(CreateUserRequest request){
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        User user = new User(
                request.getName(),
                request.getUsername(),
                request.getEmail(),
                encodedPassword,
                new ArrayList<>());
        return userRepository.save(user).toDto();
    }
}
