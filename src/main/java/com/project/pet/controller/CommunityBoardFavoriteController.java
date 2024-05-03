package com.project.pet.controller;


import com.project.pet.dto.communityboard.request.CommunityBoardFavoriteRequestDto;
import com.project.pet.dto.communityboard.request.DeleteCommunityBoardLikeReqDto;
import com.project.pet.dto.communityboard.request.GetCommunityBoardLikeReqDto;
import com.project.pet.service.CommunityBoardFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/community")
public class CommunityBoardFavoriteController {

    @Autowired
    private CommunityBoardFavoriteService communityBoardFavoriteService;


    // 게시물 좋아요 등록(단건) - 상세페이지 게시물에서 사용(Post)
    @PostMapping("/favorite")
    public ResponseEntity<?> saveCommunityBoardFavoritesCount(@RequestBody CommunityBoardFavoriteRequestDto communityBoardFavoriteRequestDto) {

        communityBoardFavoriteService.saveCommunityBoardFavoriteByBoardId(communityBoardFavoriteRequestDto);
        return ResponseEntity.created(null).body(true);
    }

    // 게시물 좋아요 취소(단건) - 상세페이지 게시물에서 사용 (Delete)
    @DeleteMapping("/delete/favorite")
        public ResponseEntity<?> deleteCommunityBoardFavorites (@RequestBody DeleteCommunityBoardLikeReqDto deleteCommunityBoardLikeReqDto) {
            communityBoardFavoriteService.deleteCommunityBoardFavoriteByBoardId(deleteCommunityBoardLikeReqDto);
            return ResponseEntity.ok(true);

    }

    @GetMapping("/favorite/count")
    public ResponseEntity<?> getBoardFavoritesCount (GetCommunityBoardLikeReqDto getCommunityBoardLikeReqDto) {
        return  ResponseEntity.ok(communityBoardFavoriteService.getBoardFavoritesCount(getCommunityBoardLikeReqDto));

    }


     //내가 좋아요한 게시물 조회.
    @GetMapping("/favorite")
    public ResponseEntity<?> getUserBoardLikeStatus (GetCommunityBoardLikeReqDto getCommunityBoardLikeReqDto) {
        System.out.println(getCommunityBoardLikeReqDto);
        boolean isLiked =  communityBoardFavoriteService.getUserBoardLikeStatus(getCommunityBoardLikeReqDto);
        return  ResponseEntity.ok(isLiked);
    }


}

