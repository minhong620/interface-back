package com.example.ifclubserver.post.application.impl;

import com.example.ifclubserver.post.application.PostService;
import com.example.ifclubserver.post.domain.dto.request.CreatePostRequest;
import com.example.ifclubserver.post.domain.dto.request.UpdatePostRequest;
import com.example.ifclubserver.post.domain.dto.response.CreatePostResponse;
import com.example.ifclubserver.post.domain.dto.response.PostDto;
import com.example.ifclubserver.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;


    @Override
    public CreatePostResponse createPost(CreatePostRequest request) {
        return null;
    }

    @Override
    public List<PostDto> getPosts(Long clubId) {
        return null;
    }

    @Override
    public PostDto getPost(Long id) {
        return null;
    }

    @Override
    public PostDto updatePost(Long id, UpdatePostRequest request) {
        return null;
    }

    @Override
    public void deletePost(Long id) {

    }
}
