package com.project.pet.dto.adoptation.request;


import com.project.pet.entity.AdoptationBoard;
import com.project.pet.entity.AdoptationBoardAdmin;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PostAdoptationBoardAdminReqDto {

    @NotNull
    private int userId;

    @NotBlank
    private String adoptationBoardAdminTitle;

    @NotBlank
    private String adoptationBoardAdminContent;





    public AdoptationBoardAdmin toEntity() {

        return AdoptationBoardAdmin.builder()
                .userId(userId)
                .adoptationBoardAdminTitle(adoptationBoardAdminTitle)
                .adoptationBoardAdminContent(adoptationBoardAdminContent)
                .build();
    }

}
