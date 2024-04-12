package com.project.pet.repository;


import com.project.pet.entity.adoptationBoard.AdoptationBoard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdoptationBoardMapper {

    //게시글 작성
    public int postAdoptationBoard(AdoptationBoard adoptationBoard);

    //전체 게시글 조회
    public List<AdoptationBoard> getAdoptationBoards();

    public List<AdoptationBoard> getAdoptationBoardsDog();

    //해당 유저id가 좋아요를 누른 게시글 리스트 조회
    public List<AdoptationBoard> getLikedAdoptationBoardByUserId(int userId);


    //해당 게시글 단건 조회
    public AdoptationBoard getAdoptationBoardByBoardId(int boardId);

    //해당 게시글 단건 삭제
    public void deleteAdoptationBoardByBoardId(int boardId);

    //해당 게시글 수정
    public int updateAdoptationBoard(AdoptationBoard adoptationBoard);

}
