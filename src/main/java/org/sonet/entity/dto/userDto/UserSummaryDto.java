package org.sonet.entity.dto.userDto;

public class UserSummaryDto {
    private final long id;
    private final String name;
    private final String username;

    public UserSummaryDto(long id, String name, String username) {
        this.id = id;
        this.name = name;
        this.username = username;
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


}
