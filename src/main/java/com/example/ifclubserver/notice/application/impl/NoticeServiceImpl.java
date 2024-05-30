package com.example.ifclubserver.notice.application.impl;

import com.example.ifclubserver.notice.application.NoticeService;
import com.example.ifclubserver.notice.domain.dto.NoticeDto;
import com.example.ifclubserver.notice.domain.dto.request.CreateNoticeRequest;
import com.example.ifclubserver.notice.domain.dto.request.UpdateNoticeRequest;
import com.example.ifclubserver.notice.domain.dto.response.CreateNoticeResponse;
import com.example.ifclubserver.notice.domain.entity.Notice;
import com.example.ifclubserver.notice.domain.repository.NoticeRepository;
import com.example.ifclubserver.notice.exception.NoticeErrorType;
import com.example.ifclubserver.notice.exception.NoticeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;

    @Override
    public CreateNoticeResponse createNotice(CreateNoticeRequest form) {
        Notice createdNotice = form.toEntity();
        return CreateNoticeResponse.from(noticeRepository.save(createdNotice));
    }

    @Override
    public NoticeDto getNotice(Long id) {
        Notice notice = noticeRepository.findById(id)
            .orElseThrow(() -> new NoticeException(NoticeErrorType.NOTICE_NOT_FOUND));
        return NoticeDto.from(notice);
    }

    @Override
    public List<NoticeDto> getNotices() {
        List<Notice> notices = noticeRepository.findAll();
        return notices.stream()
            .map(NoticeDto::from)
            .collect(Collectors.toList());
    }

    @Override
    public void deleteNotice(Long id) {
        noticeRepository.deleteById(id);
    }

    @Transactional
    @Override
    public NoticeDto updateNotice(Long id, UpdateNoticeRequest request) {
        Notice notice = noticeRepository.findById(id)
            .orElseThrow(() -> new NoticeException(NoticeErrorType.NOTICE_NOT_FOUND));
        notice.updateTitle(request.title());
        notice.updateContent(request.content());
        return NoticeDto.from(noticeRepository.save(notice));
    }
}
