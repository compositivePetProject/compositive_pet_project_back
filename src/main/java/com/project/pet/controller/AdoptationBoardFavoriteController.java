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

    //해당 userId로 좋아요 취소
    @DeleteMapping("/favorite/{userId}")
    public ResponseEntity<?> deleteAdoptationBoardFavorite(@PathVariable int userId) {
        adoptationBoardFavoriteService.deleteAdoptationBoardFavorite(userId);
        return ResponseEntity.ok("좋아요 취소 완료");
    }


    //해당 userId로 게시물에 좋아요 등록
    @PostMapping("/favorite")
    public ResponseEntity<?> saveAdoptationBoardFavorite(@RequestBody PostAdoptationBoardFavoriteReqDto postAdoptationBoardFavoriteReqDto) {
        adoptationBoardFavoriteService.saveAdoptationBoardFavorite(postAdoptationBoardFavoriteReqDto);
        return ResponseEntity.created(null).body(true);
    }


}
