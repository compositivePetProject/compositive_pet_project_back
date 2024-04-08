package com.project.pet.repository;

import com.project.pet.entity.communityBoard.CommunityBoardComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityBoardCommentMapper {

    // 커뮤니티 게시판 추가(Post)
    public int  postCommunityBoardComment(CommunityBoardComment communityBoardComment);

    // 커뮤니티 게시판 다건 조회(Get)
    public List <CommunityBoardComment> getCommunityBoardComments();

    // 커뮤니티 게시판 단건 조회(Get)
    public CommunityBoardComment getCommunityBoardComment(int CommunityCommentId);

    // 커뮤니티 게시판 단건 삭제(Delete)
    public int deleteCommunityBoardComment(int CommunityCommentId);

    // 커뮤니티 게시판 다건 삭제(Delete)
    public int deleteCommunityBoardComments(List<Integer> CommunityCommentIds);

    // 커뮤니티 게시판 단건 수정(Put)
    public int updateCommunityBoardComment(CommunityBoardComment communityBoardComment);
}
