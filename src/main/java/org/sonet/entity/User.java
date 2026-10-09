package org.sonet.entity;

import jakarta.persistence.*;
import org.sonet.entity.dto.postDto.PostContainerDto;
import org.sonet.entity.dto.postDto.PostDto;
import org.sonet.entity.dto.userDto.UserDto;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name="username", nullable = false, unique = true, length = 30)
    private String username;

    @Column(name="email", nullable = false, unique = true, length = 30)
    private String email;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;

    public User(){}

    public User(String name, String username, String email, String password, List<Post> posts) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.posts = posts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void addUserToPost(Post post){
        if (posts == null) posts = new ArrayList<>();
        posts.add(post);
        post.setUser(this);
    }

    public UserDto toDto(){
        List<PostDto> postDtos = posts.stream().
                map(Post::toDto).
                toList();
        PostContainerDto postContainerDto = new PostContainerDto(postDtos);
        return new UserDto(
                id,
                name,
                username,
                email,
                postContainerDto
        );
    }
}
