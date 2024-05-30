package com.example.ifclubserver.common.docs;

import com.example.ifclubserver.notice.domain.dto.NoticeDto;
import com.example.ifclubserver.notice.domain.dto.request.CreateNoticeRequest;
import com.example.ifclubserver.notice.domain.dto.request.UpdateNoticeRequest;
import com.example.ifclubserver.notice.domain.dto.response.CreateNoticeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "공지사항 API", description = "공지사항 관련 API")
public interface NoticeControllerDocs {

  @Operation(summary = "공지사항 생성", description = "새로운 공지사항을 생성합니다.",
      responses = {
          @ApiResponse(responseCode = "200", description = "공지사항 생성 성공",
              content = @Content(schema = @Schema(implementation = CreateNoticeResponse.class))),
          @ApiResponse(responseCode = "400", description = "잘못된 요청")
      })
  ResponseEntity<CreateNoticeResponse> create(@RequestBody CreateNoticeRequest form);

  @Operation(summary = "모든 공지사항 조회", description = "모든 공지사항 목록을 조회합니다.",
      responses = {
          @ApiResponse(responseCode = "200", description = "공지사항 조회 성공",
              content = @Content(schema = @Schema(implementation = NoticeDto.class))),
          @ApiResponse(responseCode = "404", description = "공지사항 찾을 수 없음")
      })
  ResponseEntity<List<NoticeDto>> getNotices();

  @Operation(summary = "공지사항 ID로 조회", description = "공지사항 ID를 사용하여 공지사항을 조회합니다.",
      responses = {
          @ApiResponse(responseCode = "200", description = "공지사항 조회 성공",
              content = @Content(schema = @Schema(implementation = NoticeDto.class))),
          @ApiResponse(responseCode = "404", description = "공지사항 찾을 수 없음")
      })
  ResponseEntity<NoticeDto> getNotice(@PathVariable Long id);

  @Operation(summary = "공지사항 삭제", description = "공지사항 ID를 사용하여 공지사항을 삭제합니다.",
      responses = {
          @ApiResponse(responseCode = "200", description = "공지사항 삭제 성공"),
          @ApiResponse(responseCode = "404", description = "공지사항 찾을 수 없음")
      })
  ResponseEntity<Void> deleteNotice(@PathVariable Long id);

  @Operation(summary = "공지사항 수정", description = "공지사항 ID를 사용하여 공지사항 정보를 수정합니다.",
      responses = {
          @ApiResponse(responseCode = "200", description = "공지사항 수정 성공",
              content = @Content(schema = @Schema(implementation = NoticeDto.class))),
          @ApiResponse(responseCode = "404", description = "공지사항 찾을 수 없음")
      })
  ResponseEntity<NoticeDto> updateNotice(@PathVariable Long id, @RequestBody UpdateNoticeRequest noticeUpdate);
}
