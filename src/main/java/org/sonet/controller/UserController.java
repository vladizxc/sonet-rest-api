package org.sonet.controller;

import org.sonet.entity.dto.userDto.UserDto;
import org.sonet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/current_user")
    public UserDto getCurrentUser(){
        return userService.getCurrentUser().toDto();
    }
}
