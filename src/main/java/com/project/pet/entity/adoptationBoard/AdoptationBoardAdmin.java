package com.project.pet.entity.adoptationBoard;


import com.project.pet.dto.adoptation.response.GetAdoptationBoardAdminRespDto;
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
public class AdoptationBoardAdmin {

    private int adoptationBoardAdminId;
    private int userId;
    private String adoptationBoardAdminTitle;
    private String adoptationBoardAdminContent;
    private LocalDate createDate;
    private LocalDate updateDate;
    private User user;

    public GetAdoptationBoardAdminRespDto toGetAdoptationBoardAdminRespDto() {

        return GetAdoptationBoardAdminRespDto.builder()
                .adoptationBoardAdminId(adoptationBoardAdminId)
                .userId(userId)
                .username(user.getUsername())
                .adoptationBoardAdminTitle(adoptationBoardAdminTitle)
                .adoptationBoardAdminContent(adoptationBoardAdminContent)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }

}
