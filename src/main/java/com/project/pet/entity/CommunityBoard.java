package com.project.pet.entity;

import com.project.pet.dto.communityboard.response.GetCommunityBoardResponseDto;
import com.project.pet.dto.response.GetAdoptationBoardRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommunityBoard {
    private int communityBoardId;
    private int userId;
    private String communityBoardTitle;
    private String communityBoardContent;
    private int communityBoardAnimalCategoryId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public User user;
    public CommunityBoardAnimalCategory communityBoardAnimalCategory;

 public GetCommunityBoardResponseDto toGetCommunityBoardResponseDto () {

     return  GetCommunityBoardResponseDto.builder()
             .communityBoardId(communityBoardId)
             .userId(user.getUserId())
             .username(user.getUsername())
             .communityBoardTitle(communityBoardTitle)
             .communityBoardContent(communityBoardContent)
             .communityBoardAnimalCategoryId(communityBoardAnimalCategoryId)
             .communityBoardAnimalCategoryName(communityBoardAnimalCategory.getCommunityBoardAnimalCategoryName())
             .communityBoardAnimalCategoryNameKor(communityBoardAnimalCategory.getCommunityBoardAnimalCategoryNameKor())
             .createDate(createDate)
             .updateDate(updateDate)
             .build();
    }

}
