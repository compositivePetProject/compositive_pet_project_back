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
    public ResponseEntity<?> saveCommunityBoardComment(@RequestBody CommunityBoardCommentRequestDto communityBoardCommentRequestDto) {
        communityBoardCommentService.saveCommunityComments(communityBoardCommentRequestDto);
        return  ResponseEntity.ok().body(true);

    }

    // 커뮤니티 게시판 댓글 조회(단건) - boardId를 통해 게시판에 단 댓글을 조회.
    @GetMapping("/comments/{boardId}")
    public  ResponseEntity<?> getCommunityBoardComments(@PathVariable int boardId) {
        return  ResponseEntity.ok(communityBoardCommentService.getCommunityBoardCommentsBoardId(boardId));
    }

    // 커뮤니티 게시판 댓글 조회(다건) - 상세페이지 게시물에서 사용 & 마이페이지 내가 작성한 댓글에서 사용 (Get/다건)//
    @GetMapping("/comment/{commentId}")
    public ResponseEntity<?> getCommunityBoardComment(@PathVariable int commentId) {
        return ResponseEntity.ok(communityBoardCommentService.getCommunityBoardCommentByCommentId(commentId));
    }

    // 커뮤니티 게시판 댓글 단건 삭제(Delete) - 상세페이지 게시물에서 사용
    @DeleteMapping("/delete/comment/{commentId}")
    public ResponseEntity<?> deleteCommunityBoardComment(@PathVariable int commentId) {
        communityBoardCommentService.deleteCommunityBoardCommentId(commentId);
        return  ResponseEntity.ok(true);
    }

    // 커뮤니티 게시판 댓글 다건 삭제(Delete) -  마이페이지 내가 작성한 댓글에서 사용
    @DeleteMapping("/delete/comments")
    public ResponseEntity<?> deleteCommunityBoardComments(@RequestBody List<Integer> commentIds) {
        communityBoardCommentService.deleteCommunityBoardCommentsId(commentIds);
        return ResponseEntity.ok(true);

    }

    // 커뮤니티 게시판 댓글 단건 수정(Put) -
    @PutMapping("/update/comment/{commentId}")
    public ResponseEntity<?> updateCommunityBoardComment(@PathVariable int commentId, @RequestBody UpdateCommunityBoardCommentRequestDto updateCommunityBoardCommentRequestDto) {
        updateCommunityBoardCommentRequestDto.setCommunityBoardCommentId(commentId);
        communityBoardCommentService.updateCommunityBoardCommentId(updateCommunityBoardCommentRequestDto);
        return ResponseEntity.ok().body(true);
    }
}

