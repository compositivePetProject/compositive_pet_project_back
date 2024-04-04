package com.project.pet.dto.request;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EditAdoptationBoardReqDto {

    @NotBlank
    private String adoptationBoardTitle;
    @NotBlank
    private String adoptationBoardContent;
}
