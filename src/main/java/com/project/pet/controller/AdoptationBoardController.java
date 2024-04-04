package com.project.pet.controller;


import com.project.pet.dto.request.PostAdoptationBoardReqDto;
import com.project.pet.dto.request.UpdateAdoptationBoardReqDto;
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

        return ResponseEntity.created(null).body("게시글 작성 완료");
    }

    //전체 게시판 조회(다건)
    @GetMapping("/board")
    public ResponseEntity<?> getAdoptationBoards() {
        return ResponseEntity.ok(adoptationBoardService.getAdoptationBoards());
    }

    //boardId로 게시판 조회(단건)
    @GetMapping("/board/{boardId}")
    public ResponseEntity<?> getAdoptationBoard(@PathVariable int boardId) {
        return ResponseEntity.ok(adoptationBoardService.getAdoptationBoardByBoardId(boardId));
    }

    //해당 boardId의 게시글 삭제(단건)
    @DeleteMapping("/board/{boardId}")
    public ResponseEntity<?> deleteAdoptationBoardByBoardId(@PathVariable int boardId) {
        adoptationBoardService.deleteAdoptationBoardByBoardId(boardId);

        return ResponseEntity.ok().body("해당 게시글 삭제 완료");
    }

    //해당 boardId의 게시판 수정
    @PutMapping("/board/{boardId}")
    public ResponseEntity<?> editAdoptationBoardByBoardId(
            @PathVariable int boardId,
            @RequestBody UpdateAdoptationBoardReqDto updateAdoptationBoardReqDto) {

        updateAdoptationBoardReqDto.setAdoptationBoardId(boardId);


        adoptationBoardService.updateAdoptationBoard(updateAdoptationBoardReqDto);

        return ResponseEntity.ok().body("해당 게시글 수정 완료");

    }


}
