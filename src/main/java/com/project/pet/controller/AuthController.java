package com.project.pet.controller;

import com.project.pet.aop.annotation.ValidAspect;
import com.project.pet.dto.auth.request.AuthSigninRequestDto;
import com.project.pet.dto.auth.request.AuthSignupRequestDto;
import com.project.pet.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @ValidAspect
    @PostMapping("/sign-up")
    public ResponseEntity<?> signup(@Valid @RequestBody AuthSignupRequestDto authSignupRequestDto, BindingResult bindingResult) {
        authService.signup(authSignupRequestDto);
        return ResponseEntity.created(null).body(true);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> signin(@RequestBody AuthSigninRequestDto authSigninRequestDto) {
        return ResponseEntity.created(null).body(null);
    }
}
