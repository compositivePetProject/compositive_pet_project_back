package com.project.pet.dto.adoptation.request;

import com.project.pet.entity.adoptationBoard.AdoptationBoardComment;
import com.project.pet.entity.adoptationBoard.AdoptationBoardView;
import lombok.Builder;
import lombok.Data;



@Builder
@Data
public class PostAdoptationViewReqDto {
    private int adoptationBoardId;
    private int userId;


    public AdoptationBoardView toEntity() {
        return AdoptationBoardView.builder()
                .adoptationBoardId(adoptationBoardId)
                .userId(userId)
                .build();
    }
    }

