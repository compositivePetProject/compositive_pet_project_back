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

public class CommunityBoardView {

    private int communityViewId;
    private int communityBoardId;
    private int userId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}
