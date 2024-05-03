package com.project.pet.controller;


import com.project.pet.dto.adoptation.request.PostAdoptationViewReqDto;
import com.project.pet.entity.adoptationBoard.AdoptationBoardView;
import com.project.pet.service.AdoptationBoardViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adoptation")
public class AdoptationBoardViewController {

    @Autowired
    private AdoptationBoardViewService adoptationBoardViewService;


    @PostMapping("/view")
    public ResponseEntity<?> postAdoptationView (@RequestBody PostAdoptationViewReqDto postAdoptationViewReqDto) {
        adoptationBoardViewService.postadoptationBoardView(postAdoptationViewReqDto);
        return ResponseEntity.created(null).body(postAdoptationViewReqDto);
    }

    @GetMapping("/view")
    public ResponseEntity<?> getAdoptationViewCount (@RequestParam("boardId") int boardId) {
        return ResponseEntity.ok(adoptationBoardViewService.getAdoptationBoardViewCount(boardId));
    }

    
}
