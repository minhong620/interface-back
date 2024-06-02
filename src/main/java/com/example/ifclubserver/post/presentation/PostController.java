package com.example.ifclubserver.post.presentation;

import com.example.ifclubserver.common.docs.PostControllerDocs;
import com.example.ifclubserver.post.application.PostService;
import com.example.ifclubserver.post.domain.dto.request.CreatePostRequest;
import com.example.ifclubserver.post.domain.dto.request.UpdatePostRequest;
import com.example.ifclubserver.post.domain.dto.response.CreatePostResponse;
import com.example.ifclubserver.post.domain.dto.response.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController implements PostControllerDocs {

    private final PostService postService;

    @PostMapping("/")
    ResponseEntity<CreatePostResponse> create(@RequestBody CreatePostRequest request) {
        CreatePostResponse createPostResponse = postService.createPost(request);
        return ResponseEntity.ok(createPostResponse);
    }

    @GetMapping("/")
    ResponseEntity<List<PostDto>> getPosts(@RequestParam Long clubId) {
        List<PostDto> postDtos = postService.getPosts(clubId);
        return ResponseEntity.ok(postDtos);
    }

    @GetMapping("/{postId}")
    ResponseEntity<PostDto> getPost(@PathVariable Long postId) {
        PostDto postDto = postService.getPost(postId);
        return ResponseEntity.ok(postDto);
    }

    @PatchMapping("/{postId}")
    ResponseEntity<PostDto> updatePost(@PathVariable Long postId, @RequestBody UpdatePostRequest request) {
        PostDto postDto = postService.updatePost(postId, request);
        return ResponseEntity.ok(postDto);
    }

    @DeleteMapping("/{postId}")
    ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.ok().build();
    }

}
