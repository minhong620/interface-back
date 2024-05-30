package com.example.ifclubserver.notice.presentation;

import com.example.ifclubserver.common.docs.NoticeControllerDocs;
import com.example.ifclubserver.notice.application.NoticeService;
import com.example.ifclubserver.notice.domain.dto.NoticeDto;
import com.example.ifclubserver.notice.domain.dto.request.CreateNoticeRequest;
import com.example.ifclubserver.notice.domain.dto.request.UpdateNoticeRequest;
import com.example.ifclubserver.notice.domain.dto.response.CreateNoticeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notices")
public class NoticeController implements NoticeControllerDocs {

    private final NoticeService noticeService;

    @PostMapping("/")
    public ResponseEntity<CreateNoticeResponse> create(@RequestBody CreateNoticeRequest form) {
        CreateNoticeResponse createNoticeResponse = noticeService.createNotice(form);
        return ResponseEntity.ok(createNoticeResponse);
    }

    @GetMapping("/")
    public ResponseEntity<List<NoticeDto>> getNotices() {
        List<NoticeDto> noticeDtos = noticeService.getNotices();
        return ResponseEntity.ok(noticeDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoticeDto> getNotice(@PathVariable("id") Long id) {
        NoticeDto noticeDto = noticeService.getNotice(id);
        return ResponseEntity.ok(noticeDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotice(@PathVariable Long id) {
        noticeService.deleteNotice(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoticeDto> updateNotice(@PathVariable Long id, @RequestBody UpdateNoticeRequest noticeUpdate) {
        return ResponseEntity.ok().body(noticeService.updateNotice(id, noticeUpdate));
    }
}
