package com.project.pet.repository;

import com.project.pet.entity.communityBoard.CommunityBoardCommentRating;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommunityBoardCommentRatingMapper {
    public int saveCommunityBoardCommentRating(CommunityBoardCommentRating communityBoardCommentRating);
    public int updateCommunityBoardCommentRating(CommunityBoardCommentRating communityBoardCommentRating);
}
