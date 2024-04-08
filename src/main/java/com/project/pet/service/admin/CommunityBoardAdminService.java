package com.project.pet.service.admin;

import com.project.pet.dto.communityboard.request.CommunityBoardAdminRequestDto;
import com.project.pet.dto.communityboard.request.UpdateCommunityBoardAdminRequestDto;
import com.project.pet.dto.communityboard.response.GetCommunityBoardAdminResponseDto;
import com.project.pet.entity.communityBoard.CommunityBoardAdmin;
import com.project.pet.repository.admin.CommunityBoardAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommunityBoardAdminService {

    @Autowired
    private CommunityBoardAdminMapper communityBoardAdminMapper;

    // 관리자 공지사항 게시물 작성(Post)
    public void CommunityBoardAdminRequestDto(CommunityBoardAdminRequestDto communityBoardAdminRequestDto) {
        communityBoardAdminMapper.postCommunityBoardAdmin(communityBoardAdminRequestDto.toEntity());
    }

    // 관리자 공지사항 게시물 해당BoardId로 단건 조회(Get)
    public GetCommunityBoardAdminResponseDto getCommunityBoardAdminByBoardId(int boardAdminId)  {
        CommunityBoardAdmin communityBoardAdmin = communityBoardAdminMapper.getCommunityBoardAdminByBoardId(boardAdminId);
        return communityBoardAdmin.toGetCommunityBoardAdminResponseDto();
    }

    // 관리자 공지사항 게시물 다건 조회(Get)
    public List<GetCommunityBoardAdminResponseDto> getCommunityBoardsAdminByBoardId() {
        List<CommunityBoardAdmin> communityBoardAdmins = communityBoardAdminMapper.getCommunityBoardsAdmin();
        return communityBoardAdmins.stream().map(CommunityBoardAdmin::toGetCommunityBoardAdminResponseDto).collect(Collectors.toList());
    }

    // 관리자 공지사항 게시물 해당BoardId로 단건 삭제(Delete)
    public void deleteCommunityBoardAdminByBoardId (int boardAdminId) {
        communityBoardAdminMapper.deleteCommunityBoardAdminByBoardId(boardAdminId);
    }

    // 관리자 공지사항 게시물 다건 삭제(Delete)
    public void deleteCommunityBoardsByBoardId(List<Integer> boardAdminIds) {
        communityBoardAdminMapper.deleteCommunityAdminBoards(boardAdminIds);
    }

    // 관리자 공지사항 게시물 해당BoardId로 단건 수정(Put).
    public void putCommunityAdminBoard (UpdateCommunityBoardAdminRequestDto updateCommunityBoardAdminRequestDto) {
        System.out.println(updateCommunityBoardAdminRequestDto.toEntity());
        communityBoardAdminMapper.putCommunityAdminBoard(updateCommunityBoardAdminRequestDto.toEntity());

    }
}
