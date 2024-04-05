package com.project.pet.dto.adoptation.request;


import com.project.pet.entity.AdoptationBoard;
import com.project.pet.entity.AdoptationBoardAdmin;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UpdateAdoptationBoardAdminReqDto {


    @NotNull //경로 변수 noticeId를 저장할 필드 생성
    private int adoptationBoardAdminId;

    @NotBlank
    private String adoptationBoardAdminTitle;

    @NotBlank
    private String adoptationBoardAdminContent;







    public AdoptationBoardAdmin toEntity() {

        return AdoptationBoardAdmin.builder()
                .adoptationBoardAdminId(adoptationBoardAdminId)
                .adoptationBoardAdminTitle(adoptationBoardAdminTitle)
                .adoptationBoardAdminContent(adoptationBoardAdminContent)
                .build();
    }
}
