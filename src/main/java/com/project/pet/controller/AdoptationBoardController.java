package com.project.pet.controller;


import com.project.pet.dto.request.PostAdoptationBoardReqDto;
import com.project.pet.dto.request.EditAdoptationBoardReqDto;
import com.project.pet.entity.AdoptationBoard;
import com.project.pet.service.AdoptationBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/adoptation")
public class AdoptationBoardController {

    @Autowired
    private AdoptationBoardService adoptationBoardService;

    //게시판 작성(단건)
    @PostMapping("/board")
    public ResponseEntity<?> postAdoptationBoard(@RequestBody PostAdoptationBoardReqDto postAdoptationBoardReqDto) {
        adoptationBoardService.postAdoptationBoard(postAdoptationBoardReqDto);

        return ResponseEntity.created(null).body(true);
    }

    //게시판 조회(다건)
    @GetMapping("/board")
    public ResponseEntity<?> getAdoptationBoards() {
        return ResponseEntity.ok(adoptationBoardService.getAdoptationBoards());
    }

    //게시판 조회(단건)
    @GetMapping("/board/{boardId}")
    public ResponseEntity<?> getAdoptationBoard(@PathVariable int boardId) {
        return ResponseEntity.ok(adoptationBoardService.getAdoptationBoardByBoardId(boardId));
    }

    //해당 아이디의 게시글 삭제(단건)
    @DeleteMapping("/board/{boardId}")
    public ResponseEntity<?> deleteAdoptationBoardByBoardId(@PathVariable int boardId) {
        adoptationBoardService.deleteAdoptationBoardByBoardId(boardId);

        return ResponseEntity.ok().body(true);
    }


    //해당 아이디의 게시판 수정
    @PutMapping("/board/{boardId}")
    public ResponseEntity<?> editAdoptationBoardByBoardId(
            @PathVariable int boardId,
            @RequestBody EditAdoptationBoardReqDto editAdoptationBoardReqDto) {

        editAdoptationBoardReqDto.setAdoptationBoardId(boardId);



        adoptationBoardService.updateAdoptationBoard(editAdoptationBoardReqDto);

        return ResponseEntity.ok().body(true);

    }


}
