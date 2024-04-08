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

    //공지사항 작성
    @PostMapping("/admin")
    public ResponseEntity<?> postAdoptationBoardAdmin(@RequestBody PostAdoptationBoardAdminReqDto postAdoptationBoardAdminReqDto) {
        adoptationBoardAdminService.postAdoptationBoardAdmin(postAdoptationBoardAdminReqDto);
        return ResponseEntity.created(null).body("공지 작성 완료");
    }

    //공지사항 단건 조회
    @GetMapping("/admin/{noticeId}")
    public ResponseEntity<?> getAdoptationBoardAdmin(@PathVariable int noticeId) {
        return ResponseEntity.ok(adoptationBoardAdminService.getAdoptationBoardAdmin(noticeId));
    }

    //공지사항 전체 조회(다건)
    @GetMapping("/admins")
    public ResponseEntity<?> getAdoptationBoardAdmins() {
        return ResponseEntity.ok(adoptationBoardAdminService.getAdoptationBoardAdmins());
    }
    //공지사항 단건 삭제
    @DeleteMapping("/admin/{noticeId}")
    public ResponseEntity<?> deleteAdoptationBoardAdmin(@PathVariable int noticeId) {
        adoptationBoardAdminService.deleteAdoptationBoardAdminByNoticeId(noticeId);
        return ResponseEntity.ok().body("삭제완료");
    }

}
