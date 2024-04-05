package com.project.pet.controller;

import com.project.pet.dto.communityboard.request.PostCommunityBoardRequestDto;
import com.project.pet.dto.communityboard.request.UpdateCommunityBoardRequestDto;
import com.project.pet.service.CommunityBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/community")
@RestController
public class CommunityBoardController {

    @Autowired
    CommunityBoardService communityBoardService;

    //게시판 작성 단건(post) 클래스명 변경  RegistercommunityBoardController >> CommunityBoardController
    @PostMapping("/board")
    public ResponseEntity<?> postCommunityBoard(@RequestBody PostCommunityBoardRequestDto postCommunityBoardRequestDto) {
        communityBoardService.PostCommunityBoardRequestDto(postCommunityBoardRequestDto);
        return ResponseEntity.created(null).body(true);
    }

    // 게시판 조회 다건(get)
    @GetMapping("/getboards")
    public ResponseEntity<?> getCommunityBoards() {
        return ResponseEntity.ok(communityBoardService.getCommunityBoards());
    }

    // 해당 communityBoardId의 게시판 조회 단건
    @GetMapping("/getboard/{boardId}")
    public ResponseEntity<?> getCommunityBoard(@PathVariable int boardId) {
        return ResponseEntity.ok(communityBoardService.getCommunityBoardByBoardId(boardId));
    }

    // 게시물 단건 삭제
    @DeleteMapping("/board/{boardId}")
    public ResponseEntity<?> deleteCommunityBoardByBoardId(@PathVariable int boardId) {
       communityBoardService.deleteCommunityBoardByBoardId(boardId);

       return ResponseEntity.ok().body("게시물 삭제 완료");
   }

    // 게시물 단건 수정
   @PutMapping("/board/{boardId}")
    public ResponseEntity<?> updateCommunityBoardByBoardId(
           @PathVariable int boardId,
           @RequestBody UpdateCommunityBoardRequestDto updateCommunityBoardRequestDto) {

        updateCommunityBoardRequestDto.setCommunityBoardId(boardId);
        communityBoardService.updateCommunityBoard(updateCommunityBoardRequestDto);

        return ResponseEntity.ok().body("게시물이 수정 되었습니다.");
   }


}
