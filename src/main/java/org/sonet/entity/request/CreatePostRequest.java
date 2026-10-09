package org.sonet.entity.request;

import org.sonet.entity.Post;
import org.sonet.entity.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CreatePostRequest {
    private final String content;

    public CreatePostRequest(String content) {
        this.content = content;
    }

    public Post toEntity(User user){
        return new Post(
                content,
                LocalDateTime.now(),
                0L,
                0L,
                user
        );
    }
}
