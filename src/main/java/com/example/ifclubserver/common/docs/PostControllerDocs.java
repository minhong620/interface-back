package com.example.ifclubserver.common.docs;

import com.example.ifclubserver.post.domain.dto.request.CreatePostRequest;
import com.example.ifclubserver.post.domain.dto.request.UpdatePostRequest;
import com.example.ifclubserver.post.domain.dto.response.CreatePostResponse;
import com.example.ifclubserver.post.domain.dto.response.PostDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name = "게시글 API", description = "게시글 관련 API")
public interface PostControllerDocs {

    @Operation(summary = "게시글 생성", description = "새로운 게시글을 생성합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "게시글 생성 성공",
                            content = @Content(schema = @Schema(implementation = CreatePostResponse.class))),
                    @ApiResponse(responseCode = "400", description = "잘못된 요청")
            })
    ResponseEntity<CreatePostResponse> create(@RequestBody CreatePostRequest request);

    @Operation(summary = "소모임별 게시글 조회", description = "소모임 ID를 사용하여 모든 게시글 목록을 조회합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "게시글 조회 성공",
                            content = @Content(schema = @Schema(implementation = PostDto.class))),
                    @ApiResponse(responseCode = "404", description = "게시글 찾을 수 없음")
            })
    ResponseEntity<List<PostDto>> getPosts(@RequestParam Long clubId);

    @Operation(summary = "게시글 ID로 조회", description = "게시글 ID를 사용하여 게시글을 조회합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "게시글 조회 성공",
                            content = @Content(schema = @Schema(implementation = PostDto.class))),
                    @ApiResponse(responseCode = "404", description = "게시글 찾을 수 없음")
            })
    ResponseEntity<PostDto> getPost(@PathVariable Long postId);

    @Operation(summary = "게시글 수정", description = "게시글 ID를 사용하여 게시글 정보를 수정합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "게시글 수정 성공",
                            content = @Content(schema = @Schema(implementation = PostDto.class))),
                    @ApiResponse(responseCode = "404", description = "게시글 찾을 수 없음")
            })
    ResponseEntity<PostDto> updatePost(@PathVariable Long postId, @RequestBody UpdatePostRequest request);

    @Operation(summary = "게시글 삭제", description = "게시글 ID를 사용하여 게시글을 삭제합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "게시글 삭제 성공"),
                    @ApiResponse(responseCode = "404", description = "게시글 찾을 수 없음")
            })
    ResponseEntity<Void> deletePost(@PathVariable Long postId);
}
