package org.sonet.controller;

import org.sonet.entity.dto.postDto.PostContainerDto;
import org.sonet.entity.dto.postDto.PostDto;
import org.sonet.entity.request.CreatePostRequest;
import org.sonet.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public PostContainerDto findAll(){
        return postService.findAll();
    }

    @PostMapping("/posts")
    public PostDto createPost(@RequestBody CreatePostRequest request){
        return postService.createPost(request);
    }
}
