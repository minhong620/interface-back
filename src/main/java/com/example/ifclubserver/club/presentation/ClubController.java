package com.example.ifclubserver.club.presentation;

import com.example.ifclubserver.club.application.ClubService;
import com.example.ifclubserver.club.application.impl.ClubServiceImpl;
import com.example.ifclubserver.club.domain.dto.ClubDto;
import com.example.ifclubserver.club.domain.dto.request.CreateClubRequest;
import com.example.ifclubserver.club.domain.dto.request.UpdateClubRequest;
import com.example.ifclubserver.club.domain.dto.response.CreateClubResponse;
import com.example.ifclubserver.common.docs.ClubControllerDocs;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clubs")
public class ClubController implements ClubControllerDocs {
    private final ClubService clubService;
    private final ClubServiceImpl clubServiceImpl;

    @PostMapping("/")
    public ResponseEntity<CreateClubResponse> create(@RequestBody CreateClubRequest form){
        CreateClubResponse createClubResponse=clubService.createClub(form);
        return ResponseEntity.ok(createClubResponse);
    }

    @GetMapping("/")
    public ResponseEntity<List<ClubDto>> getClubs(){
        List<ClubDto> clubDtos= clubServiceImpl.getClubs();
        return ResponseEntity.ok(clubDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClubDto> getClub(@PathVariable("id") Long id){
        ClubDto clubDto=clubServiceImpl.getClub(id);
        return ResponseEntity.ok(clubDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClub(@PathVariable Long id){
        clubServiceImpl.deleteClub(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClubDto> updateClub(@PathVariable Long id, @RequestBody UpdateClubRequest clubUpdate){
        return ResponseEntity.ok().body(clubServiceImpl.updateClub(id, clubUpdate));
    }
}
