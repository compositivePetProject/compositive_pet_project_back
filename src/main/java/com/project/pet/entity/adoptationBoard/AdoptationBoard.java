package com.project.pet.entity.adoptationBoard;


import com.project.pet.dto.adoptation.response.GetAdoptationBoardRespDto;
import com.project.pet.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public User user;
    public AdoptationBoardAnimalCategory adoptationBoardAnimalCategory;

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
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }

}
