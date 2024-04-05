package com.project.pet.service;

import com.project.pet.dto.communityboard.request.GetCommunityBoardRequestDto;
import com.project.pet.dto.communityboard.request.PostCommunityBoardRequestDto;
import com.project.pet.dto.communityboard.request.UpdateCommunityBoardRequestDto;
import com.project.pet.dto.communityboard.response.GetCommunityBoardResponseDto;
import com.project.pet.entity.CommunityBoard;
import com.project.pet.repository.CommunityBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommunityBoardService {

    @Autowired
    CommunityBoardMapper communityBoardMapper;

    // 게시물 추가 (post)
    public void  PostCommunityBoardRequestDto (PostCommunityBoardRequestDto postCommunityBoardRequestDto) {
        communityBoardMapper.postCommunityBoard(postCommunityBoardRequestDto.toEntity());
    }

    // 게시물 다건 조회
    public List<GetCommunityBoardResponseDto> getCommunityBoards () {
        List<CommunityBoard> communityBoards = communityBoardMapper.getCommunityBoards();
        System.out.println(communityBoards);
        return communityBoards.stream().map(CommunityBoard::toGetCommunityBoardResponseDto).collect(Collectors.toList());
    }

    // 게시물 단건 조회
    public GetCommunityBoardResponseDto getCommunityBoardByBoardId(int boardId) {
        CommunityBoard communityBoard = communityBoardMapper.getCommunityBoardBoardId(boardId);
        return communityBoard.toGetCommunityBoardResponseDto();
    }

    // 게시물 단건 삭제
    public void deleteCommunityBoardByBoardId(int boardId) {
        communityBoardMapper.deleteCommunityBoardByBoardId(boardId);
    }

    // 게시물 단건 수정
    public void updateCommunityBoard (UpdateCommunityBoardRequestDto updateCommunityBoardRequestDto) {
        communityBoardMapper.updateCommunityBoard(updateCommunityBoardRequestDto.toEntity());
    }

}








