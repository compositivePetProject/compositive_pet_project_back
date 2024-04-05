package com.project.pet.service.admin;

import com.project.pet.dto.communityboard.request.CommunityBoardAdminRequestDto;
import com.project.pet.dto.communityboard.response.GetCommunityAdminBoardResponseDto;
import com.project.pet.entity.CommunityBoardAdmin;
import com.project.pet.repository.admin.CommunityBoardAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityBoardAdminService {

    @Autowired
    CommunityBoardAdminMapper communityBoardAdminMapper;

            // 관리자 공지사항 게시물 추가
            public void CommunityBoardAdminRequestDto(CommunityBoardAdminRequestDto communityBoardAdminRequestDto) {

                communityBoardAdminMapper.postCommunityBoardAdmin(communityBoardAdminRequestDto.toEntity());
            }


            // 관리자 공지사항 게시물 단건 조회
            public GetCommunityAdminBoardResponseDto getCommunityBoardAdminByBoardId(int adminBoardId)  {

                CommunityBoardAdmin communityBoardAdmin = communityBoardAdminMapper.getCommunityBoardAdminByBoardId(adminBoardId);
                return communityBoardAdmin.toGetCommunityAdminBoardResponseDto();
            }





}
