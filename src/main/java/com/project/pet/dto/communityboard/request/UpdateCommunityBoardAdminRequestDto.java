package com.project.pet.dto.communityboard.request;


import com.project.pet.entity.CommunityBoardAdmin;
import lombok.Data;

@Data
public class UpdateCommunityBoardAdminRequestDto {
    private int communityBoardAdminId;
    private String communityBoardAdminTitle;
    private String communityBoardAdminContent;

    public CommunityBoardAdmin toEntity() {
        return CommunityBoardAdmin.builder()
                .communityBoardAdminId(communityBoardAdminId)
                .communityBoardAdminTitle(communityBoardAdminTitle)
                .communityBoardAdminContent(communityBoardAdminContent)
                .build();
    }
}
