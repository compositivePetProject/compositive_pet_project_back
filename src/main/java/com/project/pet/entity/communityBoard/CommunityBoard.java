package com.project.pet.entity.communityBoard;

import com.project.pet.dto.communityboard.response.GetCommunityBoardFavoriteResponseDto;
import com.project.pet.dto.communityboard.response.GetCommunityBoardLikedByUserIdResDto;
import com.project.pet.dto.communityboard.response.GetCommunityBoardResponseDto;
import com.project.pet.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    private int viewCount;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    private CommunityBoardFavorite communityBoardFavorite;
    private User user;
    private  CommunityBoardAnimalCategory communityBoardAnimalCategory;
    private  CommunityBoardView communityBoardView;



    public GetCommunityBoardResponseDto toGetCommunityBoardResponseDto () {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = createDate.toLocalDate();
        String formatCreateDate = date.format(formatter);

        LocalDate update = updateDate.toLocalDate();
        String formatUpdateDate = date.format(formatter);


     return  GetCommunityBoardResponseDto.builder()
             .communityBoardId(communityBoardId)
             .userId(user.getUserId())
             .userName(user.getUsername())
             .communityBoardTitle(communityBoardTitle)
             .communityBoardContent(communityBoardContent)
             .communityBoardAnimalCategoryName(communityBoardAnimalCategory.getCommunityBoardAnimalCategoryName())
             .communityBoardAnimalCategoryId(communityBoardAnimalCategoryId)
             .communityBoardAnimalCategoryNameKor(communityBoardAnimalCategory.getCommunityBoardAnimalCategoryNameKor())
             .viewCount(viewCount)
             .createDate(formatCreateDate)
             .updateDate(formatUpdateDate)
             .build();
    }

    public GetCommunityBoardFavoriteResponseDto toGetCommunityBoardFavoriteResponseDto() {
        return GetCommunityBoardFavoriteResponseDto.builder()
                .communityBoardId(communityBoardId)
                .userId(user.getUserId())
                .userName(user.getUsername())
                .communityBoardTitle(communityBoardTitle)
                .communityBoardContent(communityBoardContent)
                .communityBoardAnimalCategoryId(communityBoardAnimalCategoryId)
                .communityBoardAnimalCategoryName(communityBoardAnimalCategory.getCommunityBoardAnimalCategoryName())
                .communityBoardAnimalCategoryNameKor(communityBoardAnimalCategory.getCommunityBoardAnimalCategoryNameKor())
                .totalUserIdCount(communityBoardFavorite.getTotalUserIdCount())
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
