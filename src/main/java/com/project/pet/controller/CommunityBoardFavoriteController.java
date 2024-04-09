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

    // 게시물 조회(단건) (Get)
    @GetMapping("/favorite/count/{CommunityFavoriteId}")
    public ResponseEntity<?> getCommunityBoardFavoritesCount (@PathVariable int CommunityFavoriteId ) {
        return ResponseEntity.ok(communityBoardFavoriteService.getCommunityBoardFavoritesCountByBoardId(CommunityFavoriteId));
    }

    // 게시물 좋아요 등록(단건) - 상세페이지 게시물에서 사용(Post)
    @PostMapping("/favorite")
    public ResponseEntity<?> postCommunityBoardFavoritesCount(@RequestBody CommunityBoardFavoriteRequestDto communityBoardFavoriteRequestDto) {
        communityBoardFavoriteService.postCommunityBoardFavoriteByBoardId(communityBoardFavoriteRequestDto);
        return ResponseEntity.created(null).body(true);
    }

    // 게시물 좋아요 취소(단건) - 상세페이지 게시물에서 사용 (Delete)
    @DeleteMapping("/delete/favorite/{CommunityFavoriteId}")
        public ResponseEntity<?> deleteCommunityBoardFavorites (@PathVariable int CommunityBoardFavoriteId) {
            communityBoardFavoriteService.deleteCommunityBoardFavoriteByBoardId(CommunityBoardFavoriteId);
            return ResponseEntity.ok(true);

    }
}
