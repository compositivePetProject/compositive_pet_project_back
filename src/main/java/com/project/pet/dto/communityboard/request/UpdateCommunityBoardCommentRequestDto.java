package com.project.pet.dto.communityboard.request;

import com.project.pet.entity.CommunityBoardComment;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;


@Data
@Builder
public class UpdateCommunityBoardCommentRequestDto {

    private String communityBoardCommentContent;
    private int communityBoardCommentId;


    public CommunityBoardComment toEntity() {

        return CommunityBoardComment.builder()
                .communityBoardCommentId(communityBoardCommentId)
                .communityBoardCommentContent(communityBoardCommentContent)
                .build();

    }
}
