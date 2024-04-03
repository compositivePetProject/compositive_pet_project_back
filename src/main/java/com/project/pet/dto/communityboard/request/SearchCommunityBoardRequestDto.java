package com.project.pet.dto.communityboard.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchCommunityBoardRequestDto {

    private int communityBoardId;
    private int userId;
    private int communityBoardAnimalCategoryId;
    private String communityBoardTitle;
    private String communityBoardContent;


}
