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
public class CommunityBoard {
    private int communityBoardId;
    private int userId;
    private String communityBoardTitle;
    private String communityBoardContent;
    private int communityBoardAnimalCategoryId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
