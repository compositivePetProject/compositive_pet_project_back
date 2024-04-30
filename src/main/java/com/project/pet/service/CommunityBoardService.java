package com.project.pet.service;

import com.project.pet.dto.communityboard.request.*;
import com.project.pet.dto.communityboard.response.*;
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
    public GetCommunityBoardResponseDto getCommunityBoardByBoardId(GetCommunityBoardRequestDto getCommunityBoardRequestDto) {
        CommunityBoard communityBoard = communityBoardMapper.getCommunityBoardBoardId(getCommunityBoardRequestDto.getCommunityBoardId());
        return communityBoard.toGetCommunityBoardResponseDto();
    }


    public GetCommunityBoardPageCountResponseDto getBoardPageCount(GetCommunityBoardPageCountReqDto getCommunityBoardPageCountReqDto) {
        int communityBoardCount = communityBoardMapper.getBoardPageCount();
        int pageMaxNumbers  = (int) Math.ceil(((double) communityBoardCount / getCommunityBoardPageCountReqDto.getCount()));

        return  GetCommunityBoardPageCountResponseDto .builder()
                .pageMaxNumbers(pageMaxNumbers)
                .totalCount(communityBoardCount)
                .build();
    }

    public GetCommunityBoardDogCountResDto getDogBoardPageCount(GetCommunityBoardDogCountReqDto getCommunityBoardDogCountReqDto) {
        int dogBoardCount = communityBoardMapper.getDogBoardPageCount();
        int dogPageMaxNumber = (int) Math.ceil(((double) dogBoardCount / getCommunityBoardDogCountReqDto.getCount()));

        return GetCommunityBoardDogCountResDto.builder()
                .dogPageMaxNumber(dogPageMaxNumber)
                .totalCount(dogBoardCount)
                .build();
    }

    public GetCommunityBoardCatCountResDto getCatBoardPageCount(GetCommunityBoardCatCountReqDto getCommunityBoardCatCountReqDto) {
        int catBoardCount = communityBoardMapper.getCatBoardPageCount();
        int catPageMaxNumber = (int) Math.ceil(((double) catBoardCount / getCommunityBoardCatCountReqDto.getCount()));

        return GetCommunityBoardCatCountResDto.builder()
                .catPageMaxNumber(catPageMaxNumber)
                .totalCount(catBoardCount)
                .build();
    }


    public List<GetCommunityBoardFavoriteResponseDto> getFavoriteCommunityBoards(int userId) {
        List <CommunityBoard> communityBoards = communityBoardMapper.getFavoriteCommunityBoardsByUserId(userId);
        return communityBoards.stream().map(CommunityBoard::toGetCommunityBoardFavoriteResponseDto).collect(Collectors.toList());
    }

    public List<GetCommunityBoardResponseDto> getCommunityBoardsDog() {
        List <CommunityBoard> communityBoards = communityBoardMapper.getCommunityBoardsDog();
        return communityBoards.stream().map(CommunityBoard::toGetCommunityBoardResponseDto).collect(Collectors.toList());
    }

    public List<GetCommunityBoardResponseDto> getCommunityBoardCat() {
        List <CommunityBoard> communityBoards = communityBoardMapper.getCommunityBoardCat();
        return  communityBoards.stream().map(CommunityBoard::toGetCommunityBoardResponseDto).collect(Collectors.toList());
    }

    // 게시물 해당BoardId로 단건 삭제 (Delete)
    public void deleteCommunityBoardByBoardId(int communityBoardId) {
        communityBoardMapper.deleteCommunityBoardByBoardId(communityBoardId);
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








