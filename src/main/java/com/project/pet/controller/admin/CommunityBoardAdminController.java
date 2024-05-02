package com.project.pet.controller.admin;

import com.project.pet.dto.communityboard.request.CommunityBoardAdminRequestDto;
import com.project.pet.dto.communityboard.request.GetCommunityBoardAdminRequestDto;
import com.project.pet.dto.communityboard.request.UpdateCommunityBoardAdminRequestDto;
import com.project.pet.dto.communityboard.response.GetCommunityBoardAdminResponseDto;
import com.project.pet.service.admin.CommunityBoardAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/community")
@RestController
public class CommunityBoardAdminController {

    private @Autowired CommunityBoardAdminService communityBoardAdminService;

    // 커뮤니티 게시판 관리자 게시물 추가
    @PostMapping("/admin/noticewrite")
    public ResponseEntity<?> postCommunityBoardAdmin(@RequestBody CommunityBoardAdminRequestDto communityBoardAdminRequestDto) {
        communityBoardAdminService.CommunityBoardAdminRequestDto(communityBoardAdminRequestDto);
        return ResponseEntity.created(null).body(true);
    }

    // 커뮤니티 게시판 관리자 게시물 단건 조회
    @GetMapping("/admin")
    public ResponseEntity<?> getCommunityAdminBoard(GetCommunityBoardAdminRequestDto getCommunityBoardAdminRequestDto ) {
            return ResponseEntity.ok(communityBoardAdminService.getCommunityBoardAdminByBoardId(getCommunityBoardAdminRequestDto));
    }
    // 커뮤니티 게시판 관리자 게시물 다건 조회
    @GetMapping("/admin/list/boards")
    public ResponseEntity<?> getCommunityAdminBoards() {
        return ResponseEntity.ok(communityBoardAdminService.getCommunityBoardsAdminByBoardId());
    }

     // 커뮤니티 게시판  관리자 공지사항 게시물 단건 삭제
    @DeleteMapping("/delete/admin/{communityBoardAdminId}")
    public ResponseEntity<?> deleteCommunityAdminBoard(@PathVariable int communityBoardAdminId) {
        communityBoardAdminService.deleteCommunityBoardAdminByBoardId(communityBoardAdminId);
        return ResponseEntity.ok().body("게시물 삭제 완료");
    }

    // 커뮤니티 게시판 관리자 공지사항 다건 삭제
    @DeleteMapping("/delete/admin/boards")
    public ResponseEntity<?> deleteCommunityAdminBoards(@RequestBody List<Integer> boardAdminIds) {
        communityBoardAdminService.deleteCommunityBoardsByBoardId(boardAdminIds);
        return ResponseEntity.ok(true);

    }

    // 커뮤니티 게시판 관리자 공지사항 게시물 단건 수정.
    @PutMapping("/update/admin")
    public ResponseEntity<?> putCommunityAdminBoard(@RequestBody UpdateCommunityBoardAdminRequestDto updateCommunityBoardAdminRequestDto) {
        communityBoardAdminService.putCommunityAdminBoard(updateCommunityBoardAdminRequestDto);
        return ResponseEntity.ok("게시물 수정 완료");
    }

}
