package com.project.pet.dto.request;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetAdoptationBoardReqDto {

    @NotNull
    private int adoptationBoardId;

}
