package com.project.pet.repository;

import com.project.pet.entity.communityBoard.CommunityBoardFavorite;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityBoardFavoriteMapper {

    public int postCommunityBoardFavorite(CommunityBoardFavorite communityBoardFavorite);

    public List <CommunityBoardFavorite> getCommunityBoardFavorites();

    public int deleteCommunityBoardFavorite(int CommunityCommentId);
}
