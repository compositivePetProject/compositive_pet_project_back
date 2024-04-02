package com.project.pet.service;

import com.project.pet.dto.auth.request.AuthSignupRequestDto;
import com.project.pet.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional(rollbackFor = Exception.class)
    public void signup (AuthSignupRequestDto authSignupRequestDto) {
        int successCount = 0;
        successCount += userMapper.saveUser(authSignupRequestDto.toEntity(passwordEncoder));
        // 권한 설정 예정

        if(successCount < 1) {
            throw new RuntimeException();
        }
    }
}
