package com.project.pet.dto.adoptation.response;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class GetAdoptationBoardAdminRespDto {

    private int adoptationBoardAdminId;
    private int userId;
    private String username;
    private String adoptationBoardAdminTitle;
    private String adoptationBoardAdminContent;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}
