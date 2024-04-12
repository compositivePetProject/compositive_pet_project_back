package com.project.pet.controller;


import com.project.pet.dto.communityboard.request.CommunityBoardFavoriteRequestDto;
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
    @DeleteMapping("/delete/favorite/{userId}")
        public ResponseEntity<?> deleteCommunityBoardFavorites (@PathVariable int userId) {
            communityBoardFavoriteService.deleteCommunityBoardFavoriteByBoardId(userId);
            return ResponseEntity.ok(true);

    }
}
