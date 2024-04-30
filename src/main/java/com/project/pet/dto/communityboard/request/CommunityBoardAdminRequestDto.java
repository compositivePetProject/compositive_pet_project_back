package com.project.pet.dto.communityboard.request;

import com.project.pet.entity.communityBoard.CommunityBoardAdmin;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommunityBoardAdminRequestDto {

    private int userId;
    private String communityBoardAdminTitle;
    private String communityBoardAdminContent;

    public CommunityBoardAdmin toEntity() {

        return CommunityBoardAdmin.builder()

                .userId(userId)
                .communityBoardAdminTitle(communityBoardAdminTitle)
                .communityBoardAdminContent(communityBoardAdminContent)
                .build();


    }

}
