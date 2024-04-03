package com.project.pet.controller;

import com.project.pet.dto.communityboard.request.RegisterCommunityBoardRequestDto;
import com.project.pet.service.CommunityBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.hibernate.validator.internal.util.annotation.AnnotationFactory.create;

@RequestMapping("/community")
@RestController
public class communityBoardController {

@Autowired
CommunityBoardService communityBoardService;

    @PostMapping("/board")
    public ResponseEntity<?> postCommunityBoard(@RequestBody RegisterCommunityBoardRequestDto registerCommunityBoardRequestDto) {
        communityBoardService.RegisterCommunityBoardRequestDto(registerCommunityBoardRequestDto);
        return ResponseEntity.created(null).body(true);
    }



}
