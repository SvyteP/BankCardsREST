package com.example.bankcards.service;

import com.example.bankcards.dto.AccountUserLoginDTO;
import com.example.bankcards.dto.AuthGetDTO;
import com.example.bankcards.dto.base.RequestDTO;
import com.example.bankcards.dto.base.ResponseDTO;

public interface AuthService {
    ResponseDTO<AuthGetDTO> login (RequestDTO<AccountUserLoginDTO> authDTO);
}
