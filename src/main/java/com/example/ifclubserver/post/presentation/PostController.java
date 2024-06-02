package com.example.ifclubserver.post.presentation;

import com.example.ifclubserver.common.docs.PostControllerDocs;
import com.example.ifclubserver.post.application.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController implements PostControllerDocs {

    private final PostService postService;

}
