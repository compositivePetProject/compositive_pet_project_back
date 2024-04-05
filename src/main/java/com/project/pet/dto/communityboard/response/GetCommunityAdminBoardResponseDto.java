package com.project.pet.dto.communityboard.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GetCommunityAdminBoardResponseDto {

    private int communityAdminBoardId;
    private int userId;
    private String communityBoardAdminTitle;
    private String communityBoardAdminContent;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;




}
