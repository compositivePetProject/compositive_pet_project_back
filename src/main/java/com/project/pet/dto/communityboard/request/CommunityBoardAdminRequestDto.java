package com.project.pet.dto.communityboard.request;

import com.project.pet.entity.CommunityBoardAdmin;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommunityBoardAdminRequestDto {


    private int userId;
    private String communityBoardTitle;
    private String communityBoardContent;


    public CommunityBoardAdmin toEntity() {

        return CommunityBoardAdmin.builder()
                .userId(userId)
                .communityBoardTitle(communityBoardTitle)
                .communityBoardContent(communityBoardContent)
                .build();


    }





}
