package com.project.pet.service;

import com.project.pet.dto.communityboard.request.PostCommunityBoardRequestDto;
import com.project.pet.dto.communityboard.request.UpdateCommunityBoardRequestDto;
import com.project.pet.dto.communityboard.response.GetCommunityBoardFavoriteResponseDto;
import com.project.pet.dto.communityboard.response.GetCommunityBoardResponseDto;
import com.project.pet.entity.communityBoard.CommunityBoard;
import com.project.pet.repository.CommunityBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommunityBoardService {

    @Autowired
    private CommunityBoardMapper communityBoardMapper;

    // 게시물 추가 (post)
    public void  PostCommunityBoardRequestDto (PostCommunityBoardRequestDto postCommunityBoardRequestDto) {
        communityBoardMapper.postCommunityBoard(postCommunityBoardRequestDto.toEntity());
    }

    // 게시물 다건 조회 (Get)
    public List<GetCommunityBoardResponseDto> getCommunityBoards () {
        List<CommunityBoard> communityBoards = communityBoardMapper.GetCommunityBoards();
        return communityBoards.stream().map(CommunityBoard::toGetCommunityBoardResponseDto).collect(Collectors.toList());
    }

    // 게시물 해당BoardId로 단건 조회 (Get)
    public GetCommunityBoardResponseDto getCommunityBoardByBoardId(int boardId) {
        CommunityBoard communityBoard = communityBoardMapper.getCommunityBoardBoardId(boardId);
        return communityBoard.toGetCommunityBoardResponseDto();
    }

    public List<GetCommunityBoardFavoriteResponseDto> getFavoriteCommunityBoards(int userId) {
        List <CommunityBoard> communityBoards = communityBoardMapper.getFavoriteCommunityBoardsByUserId(userId);
        return communityBoards.stream().map(CommunityBoard::toGetCommunityBoardFavoriteResponseDto).collect(Collectors.toList());
    }

    public List<GetCommunityBoardResponseDto> getCommunityBoardsDog() {
        List <CommunityBoard> communityBoards = communityBoardMapper.getCommunityBoardsDog();
        return communityBoards.stream().map(CommunityBoard::toGetCommunityBoardResponseDto).collect(Collectors.toList());
    }

    // 게시물 해당BoardId로 단건 삭제 (Delete)
    public void deleteCommunityBoardByBoardId(int boardId) {
        communityBoardMapper.deleteCommunityBoardByBoardId(boardId);
    }

    // 게시물 다건 삭제 (Delete)
    public void deleteCommunityBoardsByBoardId(List<Integer> boardIds) {
        communityBoardMapper.deleteCommunityBoards(boardIds);
    }

    // 게시물 해당BoardId로 단건 수정 (Put)
    public void updateCommunityBoard (UpdateCommunityBoardRequestDto updateCommunityBoardRequestDto) {
        communityBoardMapper.updateCommunityBoard(updateCommunityBoardRequestDto.toEntity());
    }

}








