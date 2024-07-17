package com.example.ifclubserver.notice.domain.repository;

import com.example.ifclubserver.notice.domain.entity.Notice;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    Slice<Notice> findById(Long id, Pageable pageable);
}
