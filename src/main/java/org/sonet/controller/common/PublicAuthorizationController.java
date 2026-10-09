package org.sonet.controller.common;

import org.sonet.entity.dto.userDto.UserDto;
import org.sonet.entity.request.CreateUserRequest;
import org.sonet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PublicAuthorizationController {
    private final UserService userService;

    @Autowired
    public PublicAuthorizationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public UserDto createUser(@RequestBody CreateUserRequest request){
        return userService.createUser(request);
    }
}
