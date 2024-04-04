package com.project.pet.service;

import com.project.pet.dto.request.PostAdoptationBoardReqDto;
import com.project.pet.dto.request.UpdateAdoptationBoardReqDto;
import com.project.pet.dto.response.GetAdoptationBoardRespDto;
import com.project.pet.entity.AdoptationBoard;
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

    //전체 게시판 조회(다건)
    public List<GetAdoptationBoardRespDto> getAdoptationBoards() {
        List<AdoptationBoard> adoptationBoards = adoptationBoardMapper.getAdoptationBoards();
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


    //해당 게시판 수정
    public void updateAdoptationBoard(UpdateAdoptationBoardReqDto updateAdoptationBoardReqDto) {
            adoptationBoardMapper.updateAdoptationBoard(updateAdoptationBoardReqDto.toEntity());
    }

}

