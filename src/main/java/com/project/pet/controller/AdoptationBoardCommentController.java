package com.project.pet.controller;


import com.project.pet.dto.adoptation.request.PostAdoptationBoardCommentReqDto;
import com.project.pet.dto.adoptation.request.UpdateAdoptionBoardCommentReqDto;
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

    //게시판 댓글 상세 페이지 다건 조회
    @GetMapping("/comments/{boardId}")
    public ResponseEntity<?> getAdoptationBoardComment(@PathVariable int boardId) {

        return ResponseEntity.ok(adoptationBoardCommentService.getAdoptationBoardCommentByBoardId(boardId));
    }



    //게시판 댓글 단건 삭제
    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<?> DeleteAdoptationBoardCommentByCommentId(@PathVariable int commentId){
            adoptationBoardCommentService.deleteAdoptationBoardCommentByCommentId(commentId);
            return ResponseEntity.ok().body("삭제 완료");
    }

    //게시판 댓글 단건 수정
    @PutMapping("/comment/{commentId}")
    public ResponseEntity<?> DeleteAdoptationBoardCommentByCommentId(@PathVariable int commentId,
                                                                     @RequestBody UpdateAdoptionBoardCommentReqDto updateAdoptionBoardCommentReqDto) {
        updateAdoptionBoardCommentReqDto.setAdoptationBoardCommentId(commentId);
        adoptationBoardCommentService.updateAdoptationBoardCommentByCommentId(updateAdoptionBoardCommentReqDto);

        return ResponseEntity.ok(true);
    }


}
