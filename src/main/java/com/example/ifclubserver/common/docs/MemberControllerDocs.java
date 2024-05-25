package com.example.ifclubserver.common.docs;

import com.example.ifclubserver.member.domain.dto.MemberDto;
import com.example.ifclubserver.member.domain.dto.request.CreateMemberRequest;
import com.example.ifclubserver.member.domain.dto.request.UpdateMemberRequest;
import com.example.ifclubserver.member.domain.dto.response.CreateMemberResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "회원 API", description = "회원 관련 API")
public interface MemberControllerDocs {

  @Operation(summary = "회원 생성", description = "새로운 회원을 생성합니다.",
      responses = {
          @ApiResponse(responseCode = "200", description = "회원 생성 성공",
              content = @Content(schema = @Schema(implementation = CreateMemberResponse.class))),
          @ApiResponse(responseCode = "400", description = "잘못된 요청")
      })
  ResponseEntity<CreateMemberResponse> create(@RequestBody CreateMemberRequest form);

  @Operation(summary = "모든 회원 조회", description = "모든 회원 목록을 조회합니다.",
      responses = {
          @ApiResponse(responseCode = "200", description = "회원 조회 성공",
              content = @Content(schema = @Schema(implementation = MemberDto.class))),
          @ApiResponse(responseCode = "404", description = "회원 찾을 수 없음")
      })
  ResponseEntity<List<MemberDto>> getMembers();

  @Operation(summary = "회원 ID로 조회", description = "회원 ID를 사용하여 회원을 조회합니다.",
      responses = {
          @ApiResponse(responseCode = "200", description = "회원 조회 성공",
              content = @Content(schema = @Schema(implementation = MemberDto.class))),
          @ApiResponse(responseCode = "404", description = "회원 찾을 수 없음")
      })
  ResponseEntity<MemberDto> getMember(@PathVariable Long id);

  @Operation(summary = "회원 삭제", description = "회원 ID를 사용하여 회원을 삭제합니다.",
      responses = {
          @ApiResponse(responseCode = "200", description = "회원 삭제 성공"),
          @ApiResponse(responseCode = "404", description = "회원 찾을 수 없음")
      })
  ResponseEntity<Void> deleteMember(@PathVariable Long id);

  @Operation(summary = "회원 수정", description = "회원 ID를 사용하여 회원 정보를 수정합니다.",
      responses = {
          @ApiResponse(responseCode = "200", description = "회원 수정 성공",
              content = @Content(schema = @Schema(implementation = MemberDto.class))),
          @ApiResponse(responseCode = "404", description = "회원 찾을 수 없음")
      })
  ResponseEntity<MemberDto> updateMember(@PathVariable Long id, @RequestBody UpdateMemberRequest memberUpdate);
}
