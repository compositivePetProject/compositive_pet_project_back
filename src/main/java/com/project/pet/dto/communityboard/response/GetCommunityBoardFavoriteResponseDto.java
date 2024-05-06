package com.project.pet.dto.communityboard.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
public class GetCommunityBoardFavoriteResponseDto {

private int communityBoardFavoriteId;
private int communityBoardId;
private int userId;
private LocalDateTime createDate;
private LocalDateTime updateDate;
private int totalUseIdCount;

}
