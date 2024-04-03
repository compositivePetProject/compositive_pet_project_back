package com.project.pet.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class GetAdoptationBoardRespDto {
    private int adoptationBoardId;
    private int userId;
    private String adoptationBoardTitle;
    private String adoptationBoardContent;
    private int boardAnimalCategoryId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
