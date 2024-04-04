package com.project.pet.dto.request;


import com.project.pet.entity.AdoptationBoard;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class EditAdoptationBoardReqDto {

    private int adoptationBoardId;


    @NotBlank
    private String adoptationBoardTitle;

    @NotBlank
    private String adoptationBoardContent;

    @NotNull
    private int boardAnimalCategoryId;



    public AdoptationBoard toEntity() {

        return AdoptationBoard.builder()
                .adoptationBoardId(adoptationBoardId)
                .adoptationBoardTitle(adoptationBoardTitle)
                .adoptationBoardContent(adoptationBoardContent)
                .boardAnimalCategoryId(boardAnimalCategoryId)
                .build();
    }
}
