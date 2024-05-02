package com.project.pet.entity.adoptationBoard;


import com.project.pet.dto.adoptation.response.GetAdoptationBoardRespDto;
import com.project.pet.dto.adoptation.response.GetLikedAdoptationBoardByUserIdRespDto;
import com.project.pet.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdoptationBoard {

    private int adoptationBoardId;
    private int userId;
    private String adoptationBoardTitle;
    private String adoptationBoardContent;
    private int boardAnimalCategoryId;
    private LocalDate createDate;
    private LocalDate updateDate;
    private int totalCount;
    private int viewCount;

    public User user;
    public AdoptationBoardAnimalCategory adoptationBoardAnimalCategory;
    public AdoptationBoardFavorite adoptationBoardFavorite;
    public AdoptationBoardView adoptationBoardView;

    // Entity -> ResponseDto
    public GetAdoptationBoardRespDto toGetAdoptationBoardRespDto () {
        return GetAdoptationBoardRespDto.builder()
                .adoptationBoardId(adoptationBoardId)
                .userId(user.getUserId())
                .username(user.getUsername())
                .adoptationBoardTitle(adoptationBoardTitle)
                .adoptationBoardContent(adoptationBoardContent)
                .boardAnimalCategoryId(boardAnimalCategoryId)
                .boardAnimalCategoryNameKor(adoptationBoardAnimalCategory.getBoardAnimalCategoryNameKor())
                .totalCount(totalCount)
                .viewCount(viewCount)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }

    public GetLikedAdoptationBoardByUserIdRespDto toGetLikedAdoptationBoardByUserIdRespDto () {
        return GetLikedAdoptationBoardByUserIdRespDto.builder()
                .adoptationBoardId(adoptationBoardId)
                .userId(user.getUserId())
                .username(user.getUsername())
                .adoptationBoardTitle(adoptationBoardTitle)
                .adoptationBoardContent(adoptationBoardContent)
                .boardAnimalCategoryId(boardAnimalCategoryId)
                .boardAnimalCategoryNameKor(adoptationBoardAnimalCategory.getBoardAnimalCategoryNameKor())
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }




}
