package com.example.bankcards.controller;

import com.example.bankcards.dto.AccountUserLoginDTO;
import com.example.bankcards.dto.AuthGetDTO;
import com.example.bankcards.dto.base.RequestDTO;
import com.example.bankcards.dto.base.ResponseDTO;
import com.example.bankcards.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<AuthGetDTO>> login (@RequestBody RequestDTO<AccountUserLoginDTO> loginDto){
        return ResponseEntity.ok().body(authService.login(loginDto));
    }
}
