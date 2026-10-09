package org.sonet.entity;

import jakarta.persistence.*;
import org.sonet.entity.dto.postDto.PostDto;

import java.time.LocalDateTime;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="content", nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "number_of_likes")
    private long numberOfLikes;

    @Column(name = "number_of_saves")
    private long numberOFSaves;

    @ManyToOne
    @JoinColumn(name="fk_post_id")
    private User user;

    public Post(){}

    public Post(String content, LocalDateTime createdAt, long numberOfLikes, long numberOFSaves, User user) {
        this.content = content;
        this.createdAt = createdAt;
        this.numberOfLikes = numberOfLikes;
        this.numberOFSaves = numberOFSaves;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public long getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(long numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public long getNumberOFSaves() {
        return numberOFSaves;
    }

    public void setNumberOFSaves(long numberOFSaves) {
        this.numberOFSaves = numberOFSaves;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PostDto toDto(){
        return new PostDto(
                id,
                content,
                createdAt,
                numberOfLikes,
                numberOFSaves,
                user);
    }
}
