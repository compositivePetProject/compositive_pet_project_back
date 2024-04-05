package com.project.pet.controller.admin;


import com.project.pet.dto.adoptation.request.PostAdoptationBoardAdminReqDto;
import com.project.pet.service.admin.AdoptationBoardAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adoptation")
public class AdoptationBoardAdminController {

    @Autowired
    private AdoptationBoardAdminService adoptationBoardAdminService;

    @PostMapping("/admin")
    public ResponseEntity<?> postAdoptationBoardAdmin(@RequestBody PostAdoptationBoardAdminReqDto postAdoptationBoardAdminReqDto) {

        adoptationBoardAdminService.postAdoptationBoardAdmin(postAdoptationBoardAdminReqDto);

        return ResponseEntity.created(null).body("공지 작성 완료");
    }


}
