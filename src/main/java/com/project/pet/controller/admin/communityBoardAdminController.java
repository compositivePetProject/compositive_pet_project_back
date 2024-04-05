package com.project.pet.controller.admin;

import com.project.pet.dto.communityboard.request.CommunityBoardAdminRequestDto;
import com.project.pet.service.admin.CommunityBoardAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/community")
@RestController
public class communityBoardAdminController {

    @Autowired CommunityBoardAdminService communityBoardAdminService;


    // 커뮤니티 게시판 관리자 게시물 추가
    @PostMapping("/admin")
    public ResponseEntity<?> postCommunityBoardAdmin(@RequestBody CommunityBoardAdminRequestDto communityBoardAdminRequestDto) {
        communityBoardAdminService.CommunityBoardAdminRequestDto(communityBoardAdminRequestDto);
        return ResponseEntity.created(null).body(true);
    }

    // 커뮤니티 게시판 관리자 게시물 추가
    @GetMapping("/admin/{adminBoardId}")
    public ResponseEntity<?> getCommunityAdminBoard(@PathVariable int adminBoardId) {
        return ResponseEntity.ok(communityBoardAdminService.getCommunityBoardAdminByBoardId(adminBoardId));
        }

    @DeleteMapping("/admin/{adminBoardId}")
    public ResponseEntity<?> deleteCommunityAdminBoard(@PathVariable int adminBoardId) {
        communityBoardAdminService.deleteCommunityBoardAdminByBoardId(adminBoardId);

        return ResponseEntity.ok().body("게시물 삭제 완료");

    }
    }
