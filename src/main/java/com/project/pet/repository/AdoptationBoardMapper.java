package com.project.pet.repository;


import com.project.pet.dto.request.PostAdoptationBoardReqDto;
import com.project.pet.entity.AdoptationBoard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdoptationBoardMapper {


    //게시글 작성
    public int postAdoptationBoard(AdoptationBoard adoptationBoard);

    //게시글 다건 조회
    public List<AdoptationBoard> getAdoptationBoards();

    //게시글 단건 조회
    public AdoptationBoard getAdoptationBoardByBoardId(int boardId);


    //게시글 단건 삭제
    public void deleteAdoptationBoardByBoardId(int boardId);


    //게시글 수정
    public int updateAdoptationBoard(AdoptationBoard adoptationBoard);


}
