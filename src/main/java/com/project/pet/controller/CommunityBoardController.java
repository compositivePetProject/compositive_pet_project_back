package com.project.pet.controller;

import com.project.pet.dto.communityboard.request.*;
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

    // 컨트롤러 보드 변수명(boradId >> communityBoardId로 수정.)

    //커뮤니티 게시판 작성(Post) - 게시물 작성페이지에서 사용
    @PostMapping("/board/write")
    public ResponseEntity<?> postCommunityBoard(@RequestBody PostCommunityBoardRequestDto postCommunityBoardRequestDto) {
        System.out.println(postCommunityBoardRequestDto);
        communityBoardService.PostCommunityBoardRequestDto(postCommunityBoardRequestDto);
        return ResponseEntity.created(null).body(true);
    }

    // 커뮤니티 게시판 조회 다건(get)
    @GetMapping("/getboards")
    public ResponseEntity<?> getCommunityBoards() {
        return ResponseEntity.ok(communityBoardService.getCommunityBoards());
    }

    // 커뮤니티 게시판 해당 communityBoardId의 게시판 조회 단건
    @GetMapping("/board")
    public ResponseEntity<?> getCommunityBoard(GetCommunityBoardRequestDto getCommunityBoardRequestDto) {
        return ResponseEntity.ok(communityBoardService.getCommunityBoardByBoardId(getCommunityBoardRequestDto));
    }

//    @GetMapping("/board/MyList")
//    public ResponseEntity<?> getBoardByUserId (@RequestParam int userId) {
//        return ResponseEntity.ok(communityBoardService.getBoardListByUserId(userId));
//    }


    // 커뮤니티 게시판 페이지 전체 페이지네이션 (Get)
    @GetMapping("/board/count/page")
    public ResponseEntity<?> getBoardPageCount(GetCommunityBoardPageCountReqDto getCommunityBoardPageCountReqDto) {
        return  ResponseEntity.ok(communityBoardService.getBoardPageCount(getCommunityBoardPageCountReqDto));
    }

    // 커뮤니티 게시판 강아지 게시판 페이지 전체 페이지네이션 (Get)
    @GetMapping("/board/dog/count/page")
    public ResponseEntity<?> getDogBoardCountPage (GetCommunityBoardDogCountReqDto getCommunityBoardDogCountReqDto) {
        return  ResponseEntity.ok(communityBoardService.getDogBoardPageCount(getCommunityBoardDogCountReqDto));
    }

    // 커뮤니티 게시판 고양이 게시판 페이지 전체 페이지네이션 (Get)
    @GetMapping("/board/cat/count/page")
    public ResponseEntity<?> getCatBoardCountPage (GetCommunityBoardCatCountReqDto getCommunityBoardCatCountReqDto) {
        return  ResponseEntity.ok(communityBoardService.getCatBoardPageCount(getCommunityBoardCatCountReqDto));
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

    // 고양이 게시판 다건 조회
    @GetMapping("/board/cat")
    public  ResponseEntity<?> getCommunityBoardCat() {
        return ResponseEntity.ok(communityBoardService.getCommunityBoardCat());
    }

    // 게시물 단건 해당 communityBoardId의 게시판 삭제 단건
    @DeleteMapping("/delete/board/{communityBoardId}")
    public ResponseEntity<?> deleteCommunityBoard(@PathVariable int communityBoardId) {
        communityBoardService.deleteCommunityBoardByBoardId(communityBoardId);
        return ResponseEntity.ok().body("게시물 삭제 완료");
    }

    // 커뮤니티 게시판 다건 삭제 (Delete)
    @DeleteMapping("/delete/list")
    public ResponseEntity<?> deleteCommunityBoardsList(@RequestBody List<Integer> boardIds ) {
        communityBoardService.deleteCommunityBoardsByBoardId(boardIds);
        return ResponseEntity.ok(true);
    }


    // 커뮤니티 게시판 해당 communityBoardId의 단건 수정 (Put)
    @PutMapping("/board/update")
    public ResponseEntity<?> updateCommunityBoardByBoardId(@RequestBody UpdateCommunityBoardRequestDto updateCommunityBoardRequestDto) {
        communityBoardService.updateCommunityBoard(updateCommunityBoardRequestDto);
        return ResponseEntity.ok().body("게시물이 수정 되었습니다.");
    }

}
