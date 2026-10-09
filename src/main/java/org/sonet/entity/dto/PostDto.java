package org.sonet.entity.dto;

import org.sonet.entity.User;

import java.time.LocalDateTime;

public class PostDto {
    private final long id;
    private final String content;
    private final LocalDateTime createdAt;
    private final long numberOfLikes;
    private final long numberOfSaves;
    private final User user;

    public PostDto(long id, String content, LocalDateTime createdAt, long numberOfLikes, long numberOfSaves, User user) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.numberOfLikes = numberOfLikes;
        this.numberOfSaves = numberOfSaves;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public long getNumberOfLikes() {
        return numberOfLikes;
    }

    public long getNumberOfSaves() {
        return numberOfSaves;
    }

    public User getUser() {
        return user;
    }
}
