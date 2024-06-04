package com.example.ifclubserver.post.application;

import com.example.ifclubserver.post.domain.dto.request.CreatePostRequest;
import com.example.ifclubserver.post.domain.dto.request.UpdatePostRequest;
import com.example.ifclubserver.post.domain.dto.response.CreatePostResponse;
import com.example.ifclubserver.post.domain.dto.response.PostDto;

import java.util.List;

public interface PostService {

    // create post
    CreatePostResponse createPost(CreatePostRequest request);

    // get club posts
    List<PostDto> getPosts(Long clubId);

    // get single post
    PostDto getPost(Long id);

    // update post
    PostDto updatePost(Long id, UpdatePostRequest request);

    // delete post
    void deletePost(Long id);
}
