package com.project.pet.repository;

import com.project.pet.entity.CommunityBoard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityBoardMapper {


    public int postCommunityBoard(CommunityBoard communityBoard);


    // 게시판 조회 다건(get)
    public List<CommunityBoard> getCommunityBoards();


    //게시판 조회 단건
    public CommunityBoard getCommunityBoardBoardId(int boardId);

    // 게시판 단건 삭제
    public void deleteCommunityBoardByBoardId(int boardId);

    // 게시판 단건 수정
    public int updateCommunityBoard(CommunityBoard communityBoard);


    }












