package com.project.pet.repository;

import com.project.pet.entity.communityBoard.CommunityBoardComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityBoardCommentMapper {

    // 커뮤니티 게시판 추가(Post)
    public int  saveCommunityBoardComment(CommunityBoardComment communityBoardComment);

    // 커뮤니티 게시판 다건 조회(Get)
    public List <CommunityBoardComment> getCommunityBoardComments(int boardId);

    // 커뮤니티 게시판 단건 조회(Get)
    public CommunityBoardComment getCommunityBoardComment(int commentId);

    // 커뮤니티 게시판 단건 삭제(Delete)
    public int deleteCommunityBoardComment(int commentId);

    // 커뮤니티 게시판 다건 삭제(Delete)
    public int deleteCommunityBoardComments(List<Integer> commentIds);

    // 커뮤니티 게시판 단건 수정(Put)
    public int updateCommunityBoardComment(CommunityBoardComment communityBoardComment);
}
