package com.project.pet.controller;

import com.project.pet.dto.communityboard.request.PostCommunityBoardViewReqDto;
import com.project.pet.service.CommunityBoardViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/community")
public class CommunityBoardViewController {

    @Autowired
   private CommunityBoardViewService communityBoardViewService;

    @PostMapping("/view")
    public ResponseEntity<?> postCommunityBoardView(@RequestBody PostCommunityBoardViewReqDto postCommunityBoardViewReqDto) {
        communityBoardViewService.postCommunityBoardView(postCommunityBoardViewReqDto);
        return ResponseEntity.created(null).body(postCommunityBoardViewReqDto);
    }


    @GetMapping("/board/view/{communityBoardId}")
    public ResponseEntity<?> getBoardViewCount (@PathVariable int communityBoardId) {
        communityBoardViewService.getBoardViewCount(communityBoardId);
        return ResponseEntity.ok().body("true");
    }

}
