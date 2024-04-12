package com.project.pet.controller;

import com.project.pet.dto.communityboard.request.PostCommunityBoardRequestDto;
import com.project.pet.dto.communityboard.request.UpdateCommunityBoardRequestDto;
import com.project.pet.service.CommunityBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/community")
@RestController
public class CommunityBoardController {

    @Autowired
    private CommunityBoardService communityBoardService;

    //커뮤니티 게시판 작성(Post) - 게시물 작성페이지에서 사용
    @PostMapping("/board")
    public ResponseEntity<?> postCommunityBoard(@RequestBody PostCommunityBoardRequestDto postCommunityBoardRequestDto) {
        communityBoardService.PostCommunityBoardRequestDto(postCommunityBoardRequestDto);
        return ResponseEntity.created(null).body(true);
    }

    // 커뮤니티 게시판 조회 다건(get)
    @GetMapping("/getboards")
    public ResponseEntity<?> getCommunityBoards() {
        return ResponseEntity.ok(communityBoardService.getCommunityBoards());
    }

    // 커뮤니티 게시판 해당 communityBoardId의 게시판 조회 단건
    @GetMapping("/getboard/{boardId}")
    public ResponseEntity<?> getCommunityBoard(@PathVariable int boardId) {
        return ResponseEntity.ok(communityBoardService.getCommunityBoardByBoardId(boardId));
    }

    // 게시물에 좋아요를 한 userid조회
    @GetMapping("/favorite/board/{userId}")
    public ResponseEntity<?> getFavoriteCommunityBoardByUserId(@PathVariable int userId) {
        return ResponseEntity.ok(communityBoardService.getFavoriteCommunityBoards(userId));
    }

    //강아지 게시판 다건 조회
    @GetMapping("/board/dog")
    public ResponseEntity<?> getCommunityBoardDog() {
        return  ResponseEntity.ok(communityBoardService.getCommunityBoardsDog());
    }

    // 게시물 단건 해당 communityBoardId의 게시판 삭제 단건
    @DeleteMapping("/delete/board/{boardId}")
    public ResponseEntity<?> deleteCommunityBoardByBoardId(@PathVariable int boardId) {
        communityBoardService.deleteCommunityBoardByBoardId(boardId);
        return ResponseEntity.ok().body("게시물 삭제 완료");
    }

    // 커뮤니티 게시판 다건 삭제 (Delete)
    @DeleteMapping("/delete/boards")
    public ResponseEntity<?> deleteCommunityBoards(@RequestBody List<Integer> boardIds ) {
        communityBoardService.deleteCommunityBoardsByBoardId(boardIds);
        return ResponseEntity.ok(true);
    }


    // 커뮤니티 게시판 해당 communityBoardId의 단건 수정 (Put)
    @PutMapping("/update/board/{boardId}")
    public ResponseEntity<?> updateCommunityBoardByBoardId(@PathVariable int boardId, @RequestBody UpdateCommunityBoardRequestDto updateCommunityBoardRequestDto) {
        updateCommunityBoardRequestDto.setCommunityBoardId(boardId);
        communityBoardService.updateCommunityBoard(updateCommunityBoardRequestDto);
        return ResponseEntity.ok().body("게시물이 수정 되었습니다.");
    }

}