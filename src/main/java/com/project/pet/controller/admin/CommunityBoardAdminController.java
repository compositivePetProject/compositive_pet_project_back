package com.project.pet.controller.admin;

import com.project.pet.dto.communityboard.request.CommunityBoardAdminRequestDto;
import com.project.pet.dto.communityboard.request.UpdateCommunityBoardAdminRequestDto;
import com.project.pet.service.admin.CommunityBoardAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/community")
@RestController
public class CommunityBoardAdminController {

    @Autowired CommunityBoardAdminService communityBoardAdminService;

    // 커뮤니티 게시판 관리자 게시물 추가
    @PostMapping("/admin")
    public ResponseEntity<?> postCommunityBoardAdmin(@RequestBody CommunityBoardAdminRequestDto communityBoardAdminRequestDto) {
        communityBoardAdminService.CommunityBoardAdminRequestDto(communityBoardAdminRequestDto);
        return ResponseEntity.created(null).body(true);
    }

    // 커뮤니티 게시판 관리자 게시물 단건 조회
    @GetMapping("/admin/{boardAdminId}")
    public ResponseEntity<?> getCommunityAdminBoard(@PathVariable int boardAdminId) {
            return ResponseEntity.ok(communityBoardAdminService.getCommunityBoardAdminByBoardId(boardAdminId));
    }
    // 커뮤니티 게시판 관리자 게시물 다건 조회
    @GetMapping("/admin/boards")
    public ResponseEntity<?> getCommunityAdminBoards() {
        return ResponseEntity.ok(communityBoardAdminService.getCommunityBoardsAdminByBoardId());
    }

     // 커뮤니티 게시판  관리자 공지사항 게시물 단건 삭제
    @DeleteMapping("/admin/{boardAdminId}")
    public ResponseEntity<?> deleteCommunityAdminBoard(@PathVariable int boardAdminId) {
        communityBoardAdminService.deleteCommunityBoardAdminByBoardId(boardAdminId);
        return ResponseEntity.ok().body("게시물 삭제 완료");
    }

    // 커뮤니티 게시판 관리자 공지사항 다건 삭제
    @DeleteMapping("/delete/admin/boards")
    public ResponseEntity<?> deleteCommunityAdminBoards(@RequestBody List<Integer> boardAdminIds) {
        communityBoardAdminService.deleteCommunityBoardsByBoardId(boardAdminIds);
        return ResponseEntity.ok(true);

    }

    // 커뮤니티 게시판 관리자 공지사항 게시물 단건 수정.
    @PutMapping("/admin/{communityBoardAdminId}")
    public ResponseEntity<?> putCommunityAdminBoard(@PathVariable int communityBoardAdminId, @RequestBody UpdateCommunityBoardAdminRequestDto updateCommunityBoardAdminRequestDto) {
        updateCommunityBoardAdminRequestDto.setCommunityBoardAdminId(communityBoardAdminId);
        communityBoardAdminService.putCommunityAdminBoard(updateCommunityBoardAdminRequestDto);
        return ResponseEntity.ok("게시물 수정 완료");
    }

}
