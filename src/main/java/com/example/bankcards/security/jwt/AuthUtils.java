package com.example.bankcards.security.jwt;

import com.example.bankcards.dto.AuthDTO;
import com.example.bankcards.dto.base.ResponseDTO;

public interface AuthUtils {
    ResponseDTO<AuthDTO> authenticationUser(String login, String password);
}
