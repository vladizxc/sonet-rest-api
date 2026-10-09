package org.sonet.entity.dto.userDto;

import org.sonet.entity.Post;
import org.sonet.entity.dto.postDto.PostContainerDto;

import java.util.List;

public class UserDto {
    private final long id;
    private final String name;
    private final String username;
    private final String email;
    private final PostContainerDto posts;

    public UserDto(long id, String name, String username, String email, PostContainerDto posts) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.posts = posts;
    }

    public long getId() {
        return id;
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

    public PostContainerDto getPosts() {
        return posts;
    }
}
