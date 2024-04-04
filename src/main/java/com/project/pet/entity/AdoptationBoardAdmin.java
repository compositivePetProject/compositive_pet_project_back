package com.project.pet.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdoptationBoardAdmin {
    private int adoptationAdminBoardId;
    private int userId;
    private String adoptationBoardAdminTitle;
    private String adoptationBoardAdminContent;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}
