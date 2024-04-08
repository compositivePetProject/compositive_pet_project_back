package com.project.pet.controller;


import com.project.pet.dto.adoptation.request.PostAdoptationBoardCommentReqDto;
import com.project.pet.entity.adoptationBoard.AdoptationBoardComment;
import com.project.pet.service.AdoptationBoardCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adoptation")
public class AdoptationBoardCommentController {

    @Autowired
    private AdoptationBoardCommentService adoptationBoardCommentService;


    //게시판 댓글 작성
    @PostMapping("/comment")
    public ResponseEntity<?> saveAdoptationBoardComment(@RequestBody PostAdoptationBoardCommentReqDto postAdoptationBoardCommentReqDto) {
        adoptationBoardCommentService.saveAdoptationBoardComment(postAdoptationBoardCommentReqDto);
        return ResponseEntity.created(null).body("댓글 작성 완료");
    }

    //게시판 댓글 다건 조회
    @GetMapping("/comments/{boardId}")
    public ResponseEntity<?> getAdoptationBoardComment(@PathVariable int boardId) {

        return ResponseEntity.ok(adoptationBoardCommentService.getAdoptationBoardCommentByBoardId(boardId));
    }


}
