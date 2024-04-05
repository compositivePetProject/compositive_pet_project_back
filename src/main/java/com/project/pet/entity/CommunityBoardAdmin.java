package com.project.pet.entity;


import com.project.pet.dto.communityboard.response.GetCommunityAdminBoardResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommunityBoardAdmin {

    private int communityBoardAdminId;
    private int userId;
    private String communityBoardAdminTitle;
    private String communityBoardAdminContent;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public User user;

    public GetCommunityAdminBoardResponseDto toGetCommunityAdminBoardResponseDto () {

        return  GetCommunityAdminBoardResponseDto.builder()
                .communityAdminBoardId(communityBoardAdminId)
                .userId(user.getUserId())
                .communityBoardAdminTitle(communityBoardAdminTitle)
                .communityBoardAdminContent(communityBoardAdminContent)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();

    }



}
