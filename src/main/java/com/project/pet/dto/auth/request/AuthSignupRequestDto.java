package com.project.pet.dto.auth.request;

import com.project.pet.entity.User;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
public class AuthSignupRequestDto {
    @Pattern(regexp = "^[A-Za-z0-9]{4,10}$", message = "영문자, 숫자 5 ~ 10자리 형식이어야 합니다")
    private String username;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{7,128}$", message = "하나의 영문자, 숫자, 특수문자를 포함한 5 ~ 128자리 형식이어야 합니다")
    private String password;
    @Pattern(regexp = "^[가-힣]{1,}$", message = "한글문자 형식이어야 합니다")
    private String name;
    @Pattern(regexp = "^(?=.*[가-힣])[가-힣A-Za-z0-9~\\-\\. ]+(읍|면|동|가|리|길|로)\\s[0-9\\-]+$", message = "도로명 or 지번 주소 형태가 아닙니다.")
    private String address;
    @Pattern(regexp = "^01([0|1|6|7|8|9])-([0-9]{3,4})-([0-9]{4})+$",  message = "ex) 010-1234-5678 형식이어야 합니다")
    private String telNumber;
    @Pattern(regexp = "^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,16}$", message = "2자 이상 16자 이하, 영어 또는 숫자 또는 한글 형식이어야 합니다.")
    private String nickname;
    @Email(regexp =  "^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{1,3}$", message = "이메일 형식이어야 합니다")
    private String email;


    public User toEntity(BCryptPasswordEncoder passwordEncoder) {
        return User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .name(name)
                .address(address)
                .telNumber(telNumber)
                .nickname(nickname)
                .email(email)
                .build();
    }
}