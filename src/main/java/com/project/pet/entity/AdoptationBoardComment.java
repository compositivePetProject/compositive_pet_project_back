package com.project.pet.entity;


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
public class AdoptationBoardComment {
    private int adoptationBoardCommentId;
    private int adoptationBoardId;
    private int userId;
    private String adoptationBoardContent;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}