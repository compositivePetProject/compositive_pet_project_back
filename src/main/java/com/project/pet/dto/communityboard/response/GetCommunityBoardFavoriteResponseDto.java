package com.project.pet.dto.communityboard.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class GetCommunityBoardFavoriteResponseDto {

    private int communityBoardFavoriteId;
    private int userId;
    private int communityBoardId;


}
