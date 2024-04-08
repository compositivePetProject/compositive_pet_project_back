package com.project.pet.entity.communityBoard;


import com.project.pet.dto.communityboard.response.GetCommunityBoardCommentResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommunityBoardComment {
    private int communityBoardCommentId;
    private int communityBoardId;
    private int userId;
    private String communityBoardCommentContent;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public GetCommunityBoardCommentResponseDto toGetCommunityBoardCommentResponseDto() {
        return  GetCommunityBoardCommentResponseDto.builder()
                .communityBoardCommentId(communityBoardCommentId)
                .communityBoardId(communityBoardId)
                .userId(userId)
                .communityBoardCommentContent(communityBoardCommentContent)
                .build();
    }

}
