package com.example.ifclubserver.post.presentation;

import com.example.ifclubserver.common.docs.PostControllerDocs;
import com.example.ifclubserver.post.application.PostService;
import com.example.ifclubserver.post.domain.dto.request.CreatePostRequest;
import com.example.ifclubserver.post.domain.dto.request.UpdatePostRequest;
import com.example.ifclubserver.post.domain.dto.response.CreatePostResponse;
import com.example.ifclubserver.post.domain.dto.response.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController implements PostControllerDocs {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<CreatePostResponse> create(@RequestBody CreatePostRequest request) {
        CreatePostResponse createPostResponse = postService.createPost(request);
        return ResponseEntity.ok(createPostResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Slice<PostDto>> getPosts(
            @PathVariable Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Slice<PostDto> postDtos = postService.getPosts(id, page, size);
        return ResponseEntity.ok(postDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPost(@PathVariable Long id) {
        PostDto postDto = postService.getPost(id);
        return ResponseEntity.ok(postDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable Long id, @RequestBody UpdatePostRequest request) {
        PostDto postDto = postService.updatePost(id, request);
        return ResponseEntity.ok(postDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.ok().build();
    }

}
