package com.example.ifclubserver.club.domain.repository;

import com.example.ifclubserver.club.domain.entity.Club;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
    Optional<Club> findById(Long id);

    Slice<Club> findById(Long id, Pageable pageable);
}
