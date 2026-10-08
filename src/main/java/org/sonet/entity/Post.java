package org.sonet.entity;

import java.time.LocalDateTime;

public class Post {
    private long id;
    private String content;
    private LocalDateTime createdAt;
    private User user;
}
