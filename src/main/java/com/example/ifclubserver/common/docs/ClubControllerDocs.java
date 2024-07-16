package com.example.ifclubserver.common.docs;

import com.example.ifclubserver.club.domain.dto.ClubDto;
import com.example.ifclubserver.club.domain.dto.request.CreateClubRequest;
import com.example.ifclubserver.club.domain.dto.request.UpdateClubRequest;
import com.example.ifclubserver.club.domain.dto.response.CreateClubResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "소모임 API", description = "소모임 관련 API")
public interface ClubControllerDocs {

    @Operation(summary = "소모임 생성", description = "새로운 소모임을 생성합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "소모임 생성 성공",
                            content = @Content(schema = @Schema(implementation = CreateClubResponse.class))),
                    @ApiResponse(responseCode = "400", description = "잘못된 요청")
            })
    ResponseEntity<CreateClubResponse> create(@RequestBody CreateClubRequest form);

    @Operation(summary = "모든 소모임 조회", description = "모든 소모임 목록을 조회합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "소모임 조회 성공",
                            content = @Content(schema = @Schema(implementation = ClubDto.class))),
                    @ApiResponse(responseCode = "404", description = "소모임 찾을 수 없음")
            })
    ResponseEntity<Slice<ClubDto>> getClubs(@PathVariable Long id,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "10") int size);

    @Operation(summary = "소모임 ID로 조회", description = "소모임 ID를 사용하여 소모임을 조회합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "소모임 조회 성공",
                            content = @Content(schema = @Schema(implementation = ClubDto.class))),
                    @ApiResponse(responseCode = "404", description = "소모임 찾을 수 없음")
            })
    ResponseEntity<ClubDto> getClub(@PathVariable Long id);

    @Operation(summary = "소모임 삭제", description = "소모임 ID를 사용하여 소모임을 삭제합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "소모임 삭제 성공"),
                    @ApiResponse(responseCode = "404", description = "소모임 찾을 수 없음")
            })
    ResponseEntity<Void> deleteClub(@PathVariable Long id);

    @Operation(summary = "소모임 수정", description = "소모임 ID를 사용하여 소모임 정보를 수정합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "소모임 수정 성공",
                            content = @Content(schema = @Schema(implementation = ClubDto.class))),
                    @ApiResponse(responseCode = "404", description = "소모임 찾을 수 없음")
            })
    ResponseEntity<ClubDto> updateClub(@PathVariable Long id, @RequestBody UpdateClubRequest clubUpdate);
}
