package com.project.pet.entity.communityBoard;


import com.project.pet.dto.communityboard.response.GetCommunityBoardFavoriteResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommunityBoardFavorite {

    private int communityFavoriteId;
    private int communityBoardId;
    private int userId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public GetCommunityBoardFavoriteResponseDto toGetCommunityBoardFavoriteResponseDto() {

        return  GetCommunityBoardFavoriteResponseDto.builder()
                .communityBoardFavoriteId(communityFavoriteId)
                .communityBoardId(communityBoardId)
                .userId(userId)
                .build();
    }

}
