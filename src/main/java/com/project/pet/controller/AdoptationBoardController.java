package com.project.pet.controller;


import com.project.pet.dto.request.GetAdoptationBoardReqDto;
import com.project.pet.dto.request.PostAdoptationBoardReqDto;
import com.project.pet.service.AdoptationBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/adoptation")
public class AdoptationBoardController {

    @Autowired
    private AdoptationBoardService adoptationBoardService;


    @PostMapping("/board") //임의
    public ResponseEntity<?> postAdoptationBoard(@RequestBody PostAdoptationBoardReqDto postAdoptationBoardReqDto) {
        adoptationBoardService.postAdoptationBoard(postAdoptationBoardReqDto);

        return ResponseEntity.created(null).body(true);
    }

    @GetMapping("/getBoard")
    public ResponseEntity<?> getAdoptationBoard (@RequestBody GetAdoptationBoardReqDto getAdoptationBoardReqDto) {
        return ResponseEntity.ok(adoptationBoardService.GetAdoptationBoardbyBoardId(getAdoptationBoardReqDto)) ;
    }

}
