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


    @PostMapping("/favorite")
    public ResponseEntity<?> saveAdoptationBoardFavorite(@RequestBody PostAdoptationBoardFavoriteReqDto postAdoptationBoardFavoriteReqDto) {
        adoptationBoardFavoriteService.saveAdoptationBoardFavorite(postAdoptationBoardFavoriteReqDto);
        return ResponseEntity.created(null).body(true);
    }
}
