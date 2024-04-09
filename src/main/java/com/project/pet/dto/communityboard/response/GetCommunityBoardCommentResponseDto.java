package com.project.pet.dto.communityboard.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCommunityBoardCommentResponseDto {

    private int communityBoardCommentId;
    private int communityBoardId;
    private int userId;
    private String communityBoardCommentContent;

}
