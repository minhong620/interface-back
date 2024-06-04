package com.example.ifclubserver.club.application;

import com.example.ifclubserver.club.domain.dto.ClubDto;
import com.example.ifclubserver.club.domain.dto.request.CreateClubRequest;
import com.example.ifclubserver.club.domain.dto.request.UpdateClubRequest;
import com.example.ifclubserver.club.domain.dto.response.CreateClubResponse;

import java.util.List;

public interface ClubService {
    CreateClubResponse createClub(CreateClubRequest form);

    ClubDto getClub(Long id);

    List<ClubDto> getClubs();

    void deleteClub(Long id);

    ClubDto updateClub(Long id, UpdateClubRequest request);
}
