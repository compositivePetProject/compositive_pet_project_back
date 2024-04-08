package com.project.pet.controller;


import com.project.pet.dto.communityboard.request.CommunityBoardCommentRequestDto;
import com.project.pet.dto.communityboard.request.UpdateCommunityBoardCommentRequestDto;
import com.project.pet.service.CommunityBoardCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/community")
public class CommunityBoardCommentController {

    @Autowired
    private CommunityBoardCommentService communityBoardCommentService;


    // 커뮤니티 게시판 댓글 추가(Post)
    @PostMapping("/comment")
    public ResponseEntity<?> postCommunityBoardComment(@RequestBody CommunityBoardCommentRequestDto communityBoardCommentRequestDto) {
        communityBoardCommentService.postCommunityCommentByBoardId(communityBoardCommentRequestDto);
        return  ResponseEntity.ok().body(true);

    }

    // 커뮤니티 게시판 댓글 다건 조회(get)
    @GetMapping("/comments")
    public  ResponseEntity<?> getCommunityBoardComments() {
        return  ResponseEntity.ok(communityBoardCommentService.getCommunityBoardCommentsBoardId());
    }

    // 커뮤니티 게시판 댓글 단건 조회(get)
    @GetMapping("/comment/{CommunityCommentId}")
    public ResponseEntity<?> getCommunityBoardComment(@PathVariable int CommunityCommentId) {
        return ResponseEntity.ok(communityBoardCommentService.getCommunityBoardCommentBoardId(CommunityCommentId));
    }

    // 커뮤니티 게시판 댓글 단건 삭제(Delete)
    @DeleteMapping("/delete/comment/{CommunityCommentId}")
    public ResponseEntity<?> deleteCommunityBoardComment(@PathVariable int CommunityCommentId) {
        communityBoardCommentService.deleteCommunityBoardCommentId(CommunityCommentId);
        return  ResponseEntity.ok(true);
    }

    // 커뮤니티 게시판 댓글 다건 삭제(Delete)
    @DeleteMapping("/delete/comments")
    public ResponseEntity<?> deleteCommunityBoardComments(@RequestBody List<Integer> CommunityCommentIds) {
        communityBoardCommentService.deleteCommunityBoardCommentsId(CommunityCommentIds);
        return ResponseEntity.ok(true);

    }

    // 커뮤니티 게시판 댓글 단건 수정(Put)
    @PutMapping("/update/comment/{CommunityCommentId}")
    public ResponseEntity<?> updateCommunityBoardComment(@PathVariable int CommunityCommentId, @RequestBody UpdateCommunityBoardCommentRequestDto updateCommunityBoardCommentRequestDto) {
        updateCommunityBoardCommentRequestDto.setCommunityBoardCommentId(CommunityCommentId);
        communityBoardCommentService.updateCommunityBoardCommentId(updateCommunityBoardCommentRequestDto);
        return ResponseEntity.ok().body(true);
    }
}

