package com.project.pet.dto.communityboard.request;


import com.project.pet.entity.communityBoard.CommunityBoardFavorite;
import lombok.Data;

@Data
public class CommunityBoardFavoriteRequestDto {

    private int communityBoardId;

    public CommunityBoardFavorite toEntity(int userId) {

        return CommunityBoardFavorite.builder()
                .userId(userId)
                .communityBoardId(communityBoardId)
                .build();
    }
}
