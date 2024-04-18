package com.project.pet.controller;


import com.project.pet.dto.adoptation.request.GetAdoptationBoardCountReqDto;
import com.project.pet.dto.adoptation.request.PostAdoptationBoardReqDto;
import com.project.pet.dto.adoptation.request.UpdateAdoptationBoardReqDto;
import com.project.pet.dto.adoptation.response.GetAdoptationBoardCountRespDto;
import com.project.pet.service.AdoptationBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/adoptation")
public class AdoptationBoardController {

    @Autowired
    private AdoptationBoardService adoptationBoardService;

    //게시판 작성(단건)
    @PostMapping("/board")
    public ResponseEntity<?> postAdoptationBoard(@RequestBody PostAdoptationBoardReqDto postAdoptationBoardReqDto) {
        adoptationBoardService.postAdoptationBoard(postAdoptationBoardReqDto);
        return ResponseEntity.created(null).body("게시글 작성 완료");
    }

    //전체 게시판 조회(다건)
    @GetMapping("/board")
    public ResponseEntity<?> getAdoptationBoards() {
        return ResponseEntity.ok(adoptationBoardService.getAdoptationBoards());
    }

    // 전체 게시판 페이지네이션 조회
    @GetMapping("/board/count")
    public ResponseEntity<?> getAdoptationBoardCount(GetAdoptationBoardCountReqDto getAdoptationBoardCountReqDto) {
        return ResponseEntity.ok(adoptationBoardService.getAdoptationBoardCount(getAdoptationBoardCountReqDto));
    }


    //// categoryId가 1인 전체 게시판 조회(다건)
    @GetMapping("/board/dog")
    public ResponseEntity<?> getAdoptationBoardsDog() {
        return ResponseEntity.ok(adoptationBoardService.getAdoptationBoardsDog());
    }

    //// categoryId가 2인 전체 게시판 조회(다건)
    @GetMapping("/board/cat")
    public ResponseEntity<?> getAdoptationBoardsCat() {
        return ResponseEntity.ok(adoptationBoardService.getAdoptationBoardsCat());
    }



    //boardId로 해당 게시판 조회(단건)
    @GetMapping("/board/{boardId}")
    public ResponseEntity<?> getAdoptationBoard(@PathVariable int boardId) {
        return ResponseEntity.ok(adoptationBoardService.getAdoptationBoardByBoardId(boardId));
    }



    //좋아요를 한 게시물 조회 기능 추가
    @GetMapping("/board/favorite/{userId}")
    public ResponseEntity<?> getLikedAdoptationBoard(@PathVariable int userId) {
        return ResponseEntity.ok(adoptationBoardService.getLikedAdoptationBoards(userId));
    }

    //boardId로 해당 게시글 삭제(단건)
    @DeleteMapping("/board/{boardId}")
    public ResponseEntity<?> deleteAdoptationBoardByBoardId(@PathVariable int boardId) {
        adoptationBoardService.deleteAdoptationBoardByBoardId(boardId);
        return ResponseEntity.ok().body("해당 게시글 삭제 완료");
    }

    //선택된 게시판 다건 삭제
    @DeleteMapping("/board")
    public ResponseEntity<?> deleteAdoptationBoards(@RequestParam("boardIds") List<Integer> boardIds) {

        adoptationBoardService.deleteAdoptationBoards(boardIds);

        return ResponseEntity.ok().body(true);
    }

    // boardId로 해당 게시판 수정(단건)
    @PutMapping("/board/{boardId}")
    public ResponseEntity<?> editAdoptationBoardByBoardId(@PathVariable int boardId, @RequestBody UpdateAdoptationBoardReqDto updateAdoptationBoardReqDto) {
        updateAdoptationBoardReqDto.setAdoptationBoardId(boardId);
        adoptationBoardService.updateAdoptationBoard(updateAdoptationBoardReqDto);
        return ResponseEntity.ok().body("해당 게시글 수정 완료");

    }



}

