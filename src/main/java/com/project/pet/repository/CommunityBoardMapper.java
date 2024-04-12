package com.project.pet.repository;

import com.project.pet.entity.communityBoard.CommunityBoard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityBoardMapper {

    // 게시판 작성(Post)
    public int postCommunityBoard(CommunityBoard communityBoard);

    // 게시판 조회 다건(Get)
    public List<CommunityBoard> GetCommunityBoards();

    //게시판 해당BoardId로 조회 단건(Get)
    public CommunityBoard getCommunityBoardBoardId(int boardId);

    // 게시판에 좋아요한 userId조회
    public List<CommunityBoard> getFavoriteCommunityBoardsByUserId(int userId);

    public List<CommunityBoard> getCommunityBoardsDog();

    // 게시판 해당BoardId로 단건 삭제(Delete)
    public void deleteCommunityBoardByBoardId(int boardId);

    //게시판 다건 삭제(Delete)
    public int deleteCommunityBoards(List<Integer> boardIds);

    // 게시판 해당BoardId로 단건 수정(Put)
    public int updateCommunityBoard(CommunityBoard communityBoard);

}












