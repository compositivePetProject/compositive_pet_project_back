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


    // 게시물 좋아요 등록 (상세 페이지 게시물에서 사용)
    @PostMapping("/favorite")
    public ResponseEntity<?> postCommunityBoardFavorite(@RequestBody CommunityBoardFavoriteRequestDto communityBoardFavoriteRequestDto) {
        communityBoardFavoriteService.postCommunityBoardFavoriteByBoardId(communityBoardFavoriteRequestDto);
        return ResponseEntity.created(null).body(true);
    }

    @GetMapping("/favorites")
    public ResponseEntity<?> getCommunityBoardFavorites () {
        return ResponseEntity.ok(communityBoardFavoriteService.getCommunityBoardFavoritesByBoardId());

    }

    @DeleteMapping("/delete/favorite/{CommunityCommentId}")
        public ResponseEntity<?> deleteCommunityBoardFavorites (@PathVariable int CommunityCommentId) {
            communityBoardFavoriteService.deleteCommunityBoardFavoriteByBoardId(CommunityCommentId);
            return ResponseEntity.ok(true);

    }
}
