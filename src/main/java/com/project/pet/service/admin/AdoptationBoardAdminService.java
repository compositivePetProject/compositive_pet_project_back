package com.project.pet.service.admin;

import com.project.pet.dto.adoptation.request.PostAdoptationBoardAdminReqDto;
import com.project.pet.dto.adoptation.request.UpdateAdoptationBoardAdminReqDto;
import com.project.pet.dto.adoptation.response.GetAdoptationBoardAdminRespDto;
import com.project.pet.entity.adoptationBoard.AdoptationBoardAdmin;
import com.project.pet.repository.admin.AdoptationBoardAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdoptationBoardAdminService {

    @Autowired
    private AdoptationBoardAdminMapper adoptationBoardAdminMapper;

    //게시판 작성
    public void postAdoptationBoardAdmin(PostAdoptationBoardAdminReqDto postAdoptationBoardAdminReqDto) {
        adoptationBoardAdminMapper.postAdoptationBoardAdmin(postAdoptationBoardAdminReqDto.toEntity());
    }

    //게시판 단건 조회
    public GetAdoptationBoardAdminRespDto getAdoptationBoardAdmin(int noticeId) {
        AdoptationBoardAdmin adoptationBoardAdmin = adoptationBoardAdminMapper.getAdoptationBoardAdminByNoticeId(noticeId);

        return adoptationBoardAdmin.toGetAdoptationBoardAdminRespDto();
    }

    //게시판 전체 조회(다건)
    public List<GetAdoptationBoardAdminRespDto> getAdoptationBoardAdmins() {
        List<AdoptationBoardAdmin> adoptationBoardAdmins = adoptationBoardAdminMapper.getAdoptationBoardAdmins();

        return adoptationBoardAdmins
                .stream()
                .map(AdoptationBoardAdmin::toGetAdoptationBoardAdminRespDto)
                .collect(Collectors.toList());
    }

    // 게시판 단건 삭제
    public void deleteAdoptationBoardAdminByNoticeId(int noticeId) {
        adoptationBoardAdminMapper.deleteAdoptationBoardAdminByNoticeId(noticeId);
    }


    public void updateAdoptationBoardAdmin (UpdateAdoptationBoardAdminReqDto updateAdoptationBoardAdminReqDto) {
        adoptationBoardAdminMapper.updateAdoptationBoardAdmin(updateAdoptationBoardAdminReqDto.toEntity());
    }




}

