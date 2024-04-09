package com.project.pet.dto.adoptation.request;


import com.project.pet.entity.adoptationBoard.AdoptationBoardAdmin;
import lombok.Builder;
import lombok.Data;


@Data
public class UpdateAdoptationBoardAdminReqDto {

    private int adoptationBoardAdminId;

    private String adoptationBoardAdminTitle;

    private String adoptationBoardAdminContent;



    public AdoptationBoardAdmin toEntity() {
        return AdoptationBoardAdmin.builder()
                .adoptationBoardAdminId(adoptationBoardAdminId)
                .adoptationBoardAdminTitle(adoptationBoardAdminTitle)
                .adoptationBoardAdminContent(adoptationBoardAdminContent)
                .build();
    }
}
