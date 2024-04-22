package com.project.pet.service;

import com.project.pet.dto.adoptation.request.*;
import com.project.pet.dto.adoptation.response.GetAdoptationBoardCountRespDto;
import com.project.pet.dto.adoptation.response.GetAdoptationBoardDogCountRespDto;
import com.project.pet.dto.adoptation.response.GetAdoptationBoardRespDto;
import com.project.pet.dto.adoptation.response.GetLikedAdoptationBoardByUserIdRespDto;
import com.project.pet.entity.adoptationBoard.AdoptationBoard;
import com.project.pet.repository.AdoptationBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdoptationBoardService {

    @Autowired
    private AdoptationBoardMapper adoptationBoardMapper;







    //게시판 작성
    public void postAdoptationBoard(PostAdoptationBoardReqDto postAdoptationBoardReqDto) {

        adoptationBoardMapper.postAdoptationBoard(postAdoptationBoardReqDto.toEntity());

    }

    // 전체 분양 게시판 수 조회
    public GetAdoptationBoardCountRespDto getAdoptationBoardCount(GetAdoptationBoardCountReqDto getAdoptationBoardCountReqDto) {
        int adoptionBoardCount = adoptationBoardMapper.getAdoptationBoardCount();
        int maxPageNumber = (int) Math.ceil(((double) adoptionBoardCount / getAdoptationBoardCountReqDto.getCount()));
        return GetAdoptationBoardCountRespDto.builder()
                .maxPageNumber(maxPageNumber)
                .totalCount(adoptionBoardCount)
                .build();
    }


    // 강아지 분양 게시판 수 조회
    public GetAdoptationBoardDogCountRespDto getAdoptationBoardDogCount(GetAdoptationBoardDogCountReqDto getAdoptationBoardDogCountReqDto) {
        int adoptionBoardCount = adoptationBoardMapper.getAdoptationBoardDogCount();
        int maxPageNumber = (int) Math.ceil(((double) adoptionBoardCount / getAdoptationBoardDogCountReqDto.getCount()));
        return GetAdoptationBoardDogCountRespDto.builder()
                .maxPageNumberDog(maxPageNumber)
                .totalCountDog(adoptionBoardCount)
                .build();
    }

    //전체 게시판 조회(다건)
    public List<GetAdoptationBoardRespDto> getAdoptationBoards() {
        List<AdoptationBoard> adoptationBoards = adoptationBoardMapper.getAdoptationBoards();
        return adoptationBoards.stream().map(AdoptationBoard::toGetAdoptationBoardRespDto).collect(Collectors.toList());
    }

    public List<GetAdoptationBoardRespDto> getAdoptationBoardByUserId(int userId) {
        List<AdoptationBoard> adoptationBoards = adoptationBoardMapper.getAdoptationBoardByUserId(userId);
        return adoptationBoards.stream().map(AdoptationBoard::toGetAdoptationBoardRespDto).collect(Collectors.toList());
    }

    //해당 userId로 좋아요 한 게시물 조회
    public List<GetLikedAdoptationBoardByUserIdRespDto> getLikedAdoptationBoards(int userId) {
        List <AdoptationBoard> adoptationBoards = adoptationBoardMapper.getLikedAdoptationBoardByUserId(userId);
        return adoptationBoards.stream().map(AdoptationBoard::toGetLikedAdoptationBoardByUserIdRespDto).collect(Collectors.toList());
    }

    public List<GetAdoptationBoardRespDto> getAdoptationBoardsDog() {
        List <AdoptationBoard> adoptationBoards = adoptationBoardMapper.getAdoptationBoardsDog();
        return adoptationBoards.stream().map(AdoptationBoard::toGetAdoptationBoardRespDto).collect(Collectors.toList());
    }

    public List<GetAdoptationBoardRespDto> getAdoptationBoardsCat() {
        List <AdoptationBoard> adoptationBoards = adoptationBoardMapper.getAdoptationBoardsCat();
        return adoptationBoards.stream().map(AdoptationBoard::toGetAdoptationBoardRespDto).collect(Collectors.toList());
    }

    //id를 사용하여 해당 게시판 조회(단건)
    public GetAdoptationBoardRespDto getAdoptationBoardByBoardId(int boardId) {
        AdoptationBoard adoptationBoard = adoptationBoardMapper.getAdoptationBoardByBoardId(boardId);
        return adoptationBoard.toGetAdoptationBoardRespDto();
    }

    //해당 게시판 단건 삭제
    public void deleteAdoptationBoardByBoardId(int boardId) {
        adoptationBoardMapper.deleteAdoptationBoardByBoardId(boardId);
    }

    //게시판 다건 삭제
    public void deleteAdoptationBoards (List<Integer> boardIds) {
        System.out.println(boardIds);
        try {
            for (int boardId : boardIds) {
                deleteAdoptationBoardByBoardId(boardId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //해당 게시판 수정
    public void updateAdoptationBoard (UpdateAdoptationBoardReqDto updateAdoptationBoardReqDto) {
            adoptationBoardMapper.updateAdoptationBoard(updateAdoptationBoardReqDto.toEntity());
    }

}


