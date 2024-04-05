package com.project.pet.dto.communityboard.response;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


// 게시판 작성 단건(get) 응답
@Data
@Builder
public class GetCommunityBoardResponseDto {

    private int communityBoardId;
    private int userId;
    private String username;
    private String communityBoardTitle;
    private String communityBoardContent;
    private int communityBoardAnimalCategoryId;
    private String communityBoardAnimalCategoryName;
    private String communityBoardAnimalCategoryNameKor;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}
