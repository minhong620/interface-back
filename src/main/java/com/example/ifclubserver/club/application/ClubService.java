package com.example.ifclubserver.club.application;

import com.example.ifclubserver.club.domain.dto.ClubDto;
import com.example.ifclubserver.club.domain.dto.request.CreateClubRequest;
import com.example.ifclubserver.club.domain.dto.request.UpdateClubRequest;
import com.example.ifclubserver.club.domain.dto.response.CreateClubResponse;
import org.aspectj.weaver.Lint;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface ClubService {
    CreateClubResponse createClub(CreateClubRequest form);

    ClubDto getClub(Long id);

    Slice<ClubDto> getClubs(int page, int size);

    void deleteClub(Long id);

    ClubDto updateClub(Long id, UpdateClubRequest request);
}
