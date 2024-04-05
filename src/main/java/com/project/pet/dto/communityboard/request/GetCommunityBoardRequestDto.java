package com.project.pet.dto.communityboard.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

// 게시판 작성 단건(get) 요청
public class GetCommunityBoardRequestDto {

    private int communityBoardId;

}
