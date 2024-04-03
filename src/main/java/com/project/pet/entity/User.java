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
public class User {
    private int userId;
    private String username;
    private String password;
    private String name;
    private String address;
    private String telNumber;
    private String nickname;
    private String email;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}
