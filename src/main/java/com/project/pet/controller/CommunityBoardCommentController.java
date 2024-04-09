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


    // 커뮤니티 게시판 댓글 작성(단건) - 상세페이지 게시물에서 사용(Post)
    @PostMapping("/comment")
    public ResponseEntity<?> postCommunityBoardComment(@RequestBody CommunityBoardCommentRequestDto communityBoardCommentRequestDto) {
        communityBoardCommentService.postCommunityCommentByBoardId(communityBoardCommentRequestDto);
        return  ResponseEntity.ok().body(true);

    }

    // 커뮤니티 게시판 댓글 조회(다건) - 상세페이지 게시물에서 사용 & 마이페이지 내가 작성한 댓글에서 사용 (Get/다건)
    @GetMapping("/comments")
    public  ResponseEntity<?> getCommunityBoardComments() {
        return  ResponseEntity.ok(communityBoardCommentService.getCommunityBoardCommentsBoardId());
    }

    // 커뮤니티 게시판 댓글 조회(단건) - 상세페이지 게시물에서 사용
    @GetMapping("/comment/{CommunityCommentId}")
    public ResponseEntity<?> getCommunityBoardComment(@PathVariable int CommunityBoardCommentId) {
        return ResponseEntity.ok(communityBoardCommentService.getCommunityBoardCommentBoardId(CommunityBoardCommentId));
    }

    // 커뮤니티 게시판 댓글 단건 삭제(Delete) - 상세페이지 게시물에서 사용
    @DeleteMapping("/delete/comment/{CommunityCommentId}")
    public ResponseEntity<?> deleteCommunityBoardComment(@PathVariable int CommunityBoardCommentId) {
        communityBoardCommentService.deleteCommunityBoardCommentId(CommunityBoardCommentId);
        return  ResponseEntity.ok(true);
    }

    // 커뮤니티 게시판 댓글 다건 삭제(Delete) -  마이페이지 내가 작성한 댓글에서 사용
    @DeleteMapping("/delete/comments")
    public ResponseEntity<?> deleteCommunityBoardComments(@RequestBody List<Integer> CommunityBoardCommentId) {
        communityBoardCommentService.deleteCommunityBoardCommentsId(CommunityBoardCommentId);
        return ResponseEntity.ok(true);

    }

    // 커뮤니티 게시판 댓글 단건 수정(Put) -
    @PutMapping("/update/comment/{CommunityCommentId}")
    public ResponseEntity<?> updateCommunityBoardComment(@PathVariable int CommunityBoardCommentId, @RequestBody UpdateCommunityBoardCommentRequestDto updateCommunityBoardCommentRequestDto) {
        updateCommunityBoardCommentRequestDto.setCommunityBoardCommentId(CommunityBoardCommentId);
        communityBoardCommentService.updateCommunityBoardCommentId(updateCommunityBoardCommentRequestDto);
        return ResponseEntity.ok().body(true);
    }
}

