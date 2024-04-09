package com.project.pet.repository;

import com.project.pet.entity.communityBoard.CommunityBoard;
import com.project.pet.entity.communityBoard.CommunityBoardFavorite;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityBoardFavoriteMapper {

    public int postCommunityBoardFavorite(CommunityBoardFavorite communityBoardFavorite);
    public CommunityBoard getCommunityBoardFavoritesCount(int CommunityFavoriteId);
    public int deleteCommunityBoardFavorite(int boardId);
}
