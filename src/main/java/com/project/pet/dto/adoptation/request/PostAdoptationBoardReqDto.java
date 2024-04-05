package com.project.pet.dto.adoptation.request;


import com.project.pet.entity.AdoptationBoard;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PostAdoptationBoardReqDto {

    @NotBlank
    private String adoptationBoardTitle;

    private int userId;


    @NotBlank
    private String adoptationBoardContent;

    @NotNull
    private int boardAnimalCategoryId;



    public AdoptationBoard toEntity() {

        return AdoptationBoard.builder()
                .adoptationBoardTitle(adoptationBoardTitle)
                .userId(userId)
                .adoptationBoardContent(adoptationBoardContent)
                .boardAnimalCategoryId(boardAnimalCategoryId)
                .build();
    }

}
