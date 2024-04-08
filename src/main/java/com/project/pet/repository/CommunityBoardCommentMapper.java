package com.project.pet.repository;


import com.project.pet.entity.communityBoard.CommunityBoardComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityBoardCommentMapper {

    public int  postCommunityBoardComment(CommunityBoardComment communityBoardComment);
    public List <CommunityBoardComment> getCommunityBoardComments();
    public int deleteCommunityBoardComment(int CommunityCommentId);

    public int updateCommunityBoardComment(CommunityBoardComment communityBoardComment);
}
