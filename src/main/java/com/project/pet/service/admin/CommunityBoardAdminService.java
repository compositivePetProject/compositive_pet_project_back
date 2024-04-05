package com.project.pet.service.admin;

import com.project.pet.dto.communityboard.request.CommunityBoardAdminRequestDto;
import com.project.pet.dto.communityboard.request.UpdateCommunityBoardAdminRequestDto;
import com.project.pet.dto.communityboard.request.UpdateCommunityBoardRequestDto;
import com.project.pet.dto.communityboard.response.GetCommunityBoardAdminResponseDto;
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
            public GetCommunityBoardAdminResponseDto getCommunityBoardAdminByBoardId(int boardAdminId)  {

                CommunityBoardAdmin communityBoardAdmin = communityBoardAdminMapper.getCommunityBoardAdminByBoardId(boardAdminId);
                return communityBoardAdmin.toGetCommunityBoardAdminResponseDto();
            }


            // 관리자 공지사항 게시물 단건 삭제
            public void deleteCommunityBoardAdminByBoardId (int boardAdminId) {
                communityBoardAdminMapper.deleteCommunityBoardAdminByBoardId(boardAdminId);
            }

            // 관리자 공지사항 게시물 단건 수정.
            public void putCommunityAdminBoard (UpdateCommunityBoardAdminRequestDto updateCommunityBoardAdminRequestDto) {
                System.out.println(updateCommunityBoardAdminRequestDto.toEntity());
                communityBoardAdminMapper.putCommunityAdminBoard(updateCommunityBoardAdminRequestDto.toEntity());

            }


}
