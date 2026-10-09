package org.sonet.entity.dto.postDto;

import org.sonet.entity.User;
import org.sonet.entity.dto.userDto.UserDto;
import org.sonet.entity.dto.userDto.UserSummaryDto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PostDto {
    private final long id;
    private final String content;
    private final LocalDate createdAt;
    private final long numberOfLikes;
    private final long numberOfSaves;
    private final UserSummaryDto user;

    public PostDto(long id, String content, LocalDate createdAt, long numberOfLikes, long numberOfSaves, UserSummaryDto user) {
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public long getNumberOfLikes() {
        return numberOfLikes;
    }

    public long getNumberOfSaves() {
        return numberOfSaves;
    }

    public UserSummaryDto getUser() {
        return user;
    }
}
