package com.project.pet.entity.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OAuth2 {

    private int oAuth2Id;
    private int userId;
    private String oAuth2Name;
    private String providerName;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}
