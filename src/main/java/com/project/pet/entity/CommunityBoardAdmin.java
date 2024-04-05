package com.project.pet.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommunityBoardAdmin {

    private int communityBoardAdminId;
    private int userId;
    private String communityBoardAdminTitle;
    private String communityBoardAdminContent;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;



}
