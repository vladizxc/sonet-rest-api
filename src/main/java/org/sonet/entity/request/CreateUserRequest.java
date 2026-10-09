package org.sonet.entity.request;

import org.sonet.entity.User;

public class CreateUserRequest {
    private final String name;
    private final String username;
    private final String email;
    private final String password;

    public CreateUserRequest(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
