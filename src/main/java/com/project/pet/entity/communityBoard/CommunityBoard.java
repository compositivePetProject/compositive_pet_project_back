package com.project.pet.entity.communityBoard;

import com.project.pet.dto.communityboard.response.GetCommunityBoardFavoriteResponseDto;
import com.project.pet.dto.communityboard.response.GetCommunityBoardLikedByUserIdResDto;
import com.project.pet.dto.communityboard.response.GetCommunityBoardResponseDto;
import com.project.pet.entity.user.User;
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
    private User user;
    private CommunityBoardAnimalCategory communityBoardAnimalCategory;
    private CommunityBoardView communityBoardView;
    private CommunityBoardFavorite communityBoardFavorite;
    private int totalCount;

    public GetCommunityBoardResponseDto toGetCommunityBoardResponseDto () {
     return  GetCommunityBoardResponseDto.builder()
             .communityBoardId(communityBoardId)
//             .userId(userId)
//             .userName(user.getUsername())
             .communityBoardTitle(communityBoardTitle)
             .communityBoardContent(communityBoardContent)
//             .communityBoardAnimalCategoryName(communityBoardAnimalCategory.getCommunityBoardAnimalCategoryName())
             .communityBoardAnimalCategoryId(communityBoardAnimalCategoryId)
//             .communityBoardAnimalCategoryNameKor(communityBoardAnimalCategory.getCommunityBoardAnimalCategoryNameKor())
             .totalCount(totalCount)
             .createDate(createDate)
             .updateDate(updateDate)
             .build();
    }


    public GetCommunityBoardLikedByUserIdResDto toGetCommunityBoardLikedByUserIdResDto() {
        return  GetCommunityBoardLikedByUserIdResDto.builder()
                .communityBoardId(communityBoardId)
                .userId(user.getUserId())
                .userName(user.getUsername())
                .communityBoardTitle(communityBoardTitle)
                .communityBoardContent(communityBoardContent)
                .communityBoardAnimalCategoryId(communityBoardAnimalCategoryId)
                .communityBoardAnimalCategoryNameKor(communityBoardAnimalCategory.getCommunityBoardAnimalCategoryNameKor())
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }

}
