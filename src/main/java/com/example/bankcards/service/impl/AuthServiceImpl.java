package com.example.bankcards.service.impl;

import com.example.bankcards.dto.AuthGetDTO;
import com.example.bankcards.dto.AccountUserLoginDTO;
import com.example.bankcards.dto.base.RequestDTO;
import com.example.bankcards.dto.base.ResponseDTO;
import com.example.bankcards.security.jwt.AuthUtils;
import com.example.bankcards.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthUtils authUtils;

    public AuthServiceImpl(AuthUtils authUtils) {
        this.authUtils = authUtils;
    }

    @Override
    public ResponseDTO<AuthGetDTO> login(RequestDTO<AccountUserLoginDTO> authDTO) {
        AccountUserLoginDTO userLoginDTO = authDTO.requestBody();
        return authUtils.authenticationUser(userLoginDTO.login(),userLoginDTO.password());
    }
}
