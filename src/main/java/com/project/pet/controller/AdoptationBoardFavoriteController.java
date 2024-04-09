package com.project.pet.controller;


import com.project.pet.dto.adoptation.request.PostAdoptationBoardFavoriteReqDto;
import com.project.pet.service.AdoptationBoardFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adoptation")
public class AdoptationBoardFavoriteController {

    @Autowired
    private AdoptationBoardFavoriteService adoptationBoardFavoriteService;


    @DeleteMapping("/favorite/{boardId}/{userId}")
    public ResponseEntity<?> deleteAdoptationBoardFavorite( @PathVariable int boardId, @PathVariable int userId) {
        adoptationBoardFavoriteService.deleteAdoptationBoardFavorite(boardId, userId);
        return ResponseEntity.ok("좋아요 취소 완료");
    }

    @PostMapping("/favorite")
    public ResponseEntity<?> saveAdoptationBoardFavorite(@RequestBody PostAdoptationBoardFavoriteReqDto postAdoptationBoardFavoriteReqDto) {
        adoptationBoardFavoriteService.saveAdoptationBoardFavorite(postAdoptationBoardFavoriteReqDto);
        return ResponseEntity.created(null).body(true);
    }
}
