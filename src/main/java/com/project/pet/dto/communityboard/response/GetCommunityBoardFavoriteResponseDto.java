package com.project.pet.dto.communityboard.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
public class GetCommunityBoardFavoriteResponseDto {

    private int communityBoardId;
    private int userId;
    private String userName;
    private String communityBoardTitle;
    private String communityBoardContent;
    private int communityBoardAnimalCategoryId;
    private String communityBoardAnimalCategoryName;
    private String communityBoardAnimalCategoryNameKor;
    private int totalUserIdCount;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;


}
