package com.project.pet.controller.admin;

import com.project.pet.dto.communityboard.request.CommunityBoardAdminRequestDto;
import com.project.pet.service.CommunityBoardAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/community")
@RestController
public class communityBoardAdminController {

    @Autowired CommunityBoardAdminService communityBoardAdminService;


    @PostMapping("/admin")
    public ResponseEntity<?> postCommunityBoardAdmin(@RequestBody CommunityBoardAdminRequestDto communityBoardAdminRequestDto) {
        communityBoardAdminService.CommunityBoardAdminRequestDto(communityBoardAdminRequestDto);
        return ResponseEntity.created(null).body(true);
    }

}
