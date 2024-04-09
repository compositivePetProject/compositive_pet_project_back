package com.project.pet.dto.communityboard.request;
import com.project.pet.entity.communityBoard.CommunityBoardComment;
import lombok.Builder;
import lombok.Data;


@Data
public class CommunityBoardCommentRequestDto {

    private int userId;
    private int communityBoardId;
    private String communityBoardCommentContent;


    public CommunityBoardComment toEntity() {

        return  CommunityBoardComment.builder()
                .communityBoardId(communityBoardId)
                .userId(userId)
                .communityBoardCommentContent(communityBoardCommentContent)
                .build();

    }

}
