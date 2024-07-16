package com.example.ifclubserver.club.application.impl;


import com.example.ifclubserver.club.application.ClubService;
import com.example.ifclubserver.club.domain.dto.ClubDto;
import com.example.ifclubserver.club.domain.dto.request.CreateClubRequest;
import com.example.ifclubserver.club.domain.dto.request.UpdateClubRequest;
import com.example.ifclubserver.club.domain.dto.response.CreateClubResponse;
import com.example.ifclubserver.club.domain.entity.Club;
import com.example.ifclubserver.club.domain.repository.ClubRepository;
import com.example.ifclubserver.club.exception.ClubErrorType;
import com.example.ifclubserver.club.exception.ClubException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClubServiceImpl implements ClubService {
    private final ClubRepository clubRepository;
    private final RestTemplateAutoConfiguration restTemplateAutoConfiguration;

    @Override
    public CreateClubResponse createClub(CreateClubRequest form) {
        Club createdClub=form.toEntity();
        return CreateClubResponse.from(clubRepository.save(createdClub));
    }

    @Override
    public ClubDto getClub(Long id){
        Club club=clubRepository.findById(id)
                .orElseThrow(()->new ClubException(ClubErrorType.NOTICE_NOT_FOUND));

        return ClubDto.from(club);
    }

    @Override
    public Slice<ClubDto> getClubs(Long id, int page, int size) {
        PageRequest pageRequest=PageRequest.of(page,size);
        Slice<Club> clubPage = clubRepository.findById(id, pageRequest);
        return clubPage.map(ClubDto::from);
    }

    @Override
    public void deleteClub(Long id) {
        clubRepository.deleteById(id);
    }

    @Transactional
    @Override
    public ClubDto updateClub(Long id, UpdateClubRequest request) {
        Club club=clubRepository.findById(id)
                .orElseThrow(()->new ClubException(ClubErrorType.NOTICE_NOT_FOUND));
        club.updateName(request.name());
        club.updateContent(request.content());
        club.updateImageUrl(request.image_url());
        club.updateLeader(request.leader());

        return ClubDto.from(clubRepository.save(club));
    }
}
