package com.project.pet.service;

import com.project.pet.dto.account.request.AccountEditNicknameRequestDto;
import com.project.pet.dto.account.request.AccountEditPasswordRequestDto;
import com.project.pet.dto.account.request.AccountEditProfileImageUrlRequestDto;
import com.project.pet.entity.user.User;
import com.project.pet.exception.ValidException;
import com.project.pet.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.Map;

@Service
public class AccountService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userMapper.findUserByUsername(authentication.getName());
    }

    public void editPassword(AccountEditPasswordRequestDto accountEditPasswordRequestDto) {
        User user = getCurrentUser();

        if(!passwordEncoder.matches(accountEditPasswordRequestDto.getOldPassword(), user.getPassword())) {
            throw new ValidException(Map.of("oldPassword", "비밀번호 인증에 실패하였습니다. 다시 입력하세요"));
        }
        if(!accountEditPasswordRequestDto.getNewPassword().equals(accountEditPasswordRequestDto.getNewPasswordCheck())) {
            throw new ValidException(Map.of("newPasswordCheck", "새로운 비밀번호가 서로 일치하지 않습니다. 다시 입력하세요"));
        }
        if(passwordEncoder.matches(accountEditPasswordRequestDto.getNewPassword(), user.getPassword())) {
            throw new ValidException(Map.of("newPasswordCheck", "이전 비밀번호와 동일한 비밀번호는 사용하실 수 없습니다. 다시 입력하세요"));
        }
        user.setPassword(passwordEncoder.encode(accountEditPasswordRequestDto.getNewPassword()));
        userMapper.editPassword(user);
    }

    public void editNickname(AccountEditNicknameRequestDto accountEditNicknameRequestDto) {
        User user = getCurrentUser();

        if(!accountEditNicknameRequestDto.getOldNickname().equals(user.getNickname())) {
            throw new ValidException(Map.of("oldNickname", "입력한 닉네임은 현재의 닉네임과 일치하지 않습니다. 이전 닉네임을 다시 확인해주세요."));
        }

        if(userMapper.findUserByNickname(accountEditNicknameRequestDto.getNewNickname()) != null) {
            throw new ValidException(Map.of("newNickname", "입력한 닉네임은 이미 다른 사용자에 의해 사용 중입니다. 다른 닉네임을 입력해주세요."));
        }

        user.setNickname(accountEditNicknameRequestDto.getNewNickname());
        userMapper.editNickname(user);
    }

    public void updateProfileImageUrl(AccountEditProfileImageUrlRequestDto accountEditProfileImageUrlRequestDto) {
        User user = getCurrentUser();

        if(!accountEditProfileImageUrlRequestDto.getOldProfileImageUrl().equals(user.getProfileImageUrl())) {
            throw new ValidException(Map.of("oldProfileImageUrl", "입력한 이전 프로필 이미지와 현재의 프로필 이미지는 일치합니다. 다른 이미지를 입력해주세요."));
        }

        user.setProfileImageUrl(accountEditProfileImageUrlRequestDto.getNewProfileImageUrl());
        userMapper.updateProfileImageUrl(user);
    }
}
