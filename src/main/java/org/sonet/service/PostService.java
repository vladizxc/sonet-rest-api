package org.sonet.service;

import jakarta.transaction.Transactional;
import org.sonet.entity.Post;
import org.sonet.entity.User;
import org.sonet.entity.dto.postDto.PostContainerDto;
import org.sonet.entity.dto.postDto.PostDto;
import org.sonet.entity.request.CreatePostRequest;
import org.sonet.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PostService {

    private final UserService userService;
    private final PostRepository postRepository;

    @Autowired
    public PostService(UserService userService, PostRepository postRepository){
        this.userService=userService;
        this.postRepository=postRepository;
    }

    public PostContainerDto findAll(){
        List<PostDto> posts = postRepository.findAll()
                .stream()
                .map(Post::toDto)
                .toList();
        return new PostContainerDto(posts);
    }

    public PostDto createPost(CreatePostRequest request){
        User user = userService.getCurrentUser();
        return postRepository.save(request.toEntity(user)).toDto();
    }
}
