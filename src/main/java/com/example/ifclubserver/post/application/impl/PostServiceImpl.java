package com.example.ifclubserver.post.application.impl;

import com.example.ifclubserver.post.application.PostService;
import com.example.ifclubserver.post.domain.dto.request.CreatePostRequest;
import com.example.ifclubserver.post.domain.dto.request.UpdatePostRequest;
import com.example.ifclubserver.post.domain.dto.response.CreatePostResponse;
import com.example.ifclubserver.post.domain.dto.response.PostDto;
import com.example.ifclubserver.post.domain.entity.Post;
import com.example.ifclubserver.post.domain.repository.PostRepository;
import com.example.ifclubserver.post.exception.PostErrorType;
import com.example.ifclubserver.post.exception.PostException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;


    @Override
    public CreatePostResponse createPost(CreatePostRequest request) {
        Post post = postRepository.save(request.toEntity());
        return CreatePostResponse.of(post);
    }

    @Override
    @Transactional(readOnly = true)
    public Slice<PostDto> getPosts(Long id, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Slice<Post> postPage = postRepository.findByClubId(id, pageRequest);
        return postPage.map(PostDto::of);
    }

    @Override
    @Transactional(readOnly = true)
    public PostDto getPost(Long id) {
        Post post = getById(id);
        return PostDto.of(post);
    }

    @Override
    @Transactional
    public PostDto updatePost(Long id, UpdatePostRequest request) {
        Post post = getById(id);
        post.updatePost(request.title(), request.content());
        post = postRepository.save(post);
        return PostDto.of(post);
    }

    @Override
    @Transactional
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    private Post getById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new PostException(PostErrorType.POST_NOT_FOUND));
    }
}
