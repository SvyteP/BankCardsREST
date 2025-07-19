package com.example.bankcards.security.jwt;

import com.example.bankcards.dto.AuthGetDTO;
import com.example.bankcards.dto.base.ResponseDTO;

public interface AuthUtils {
    ResponseDTO<AuthGetDTO> authenticationUser(String login, String password);
}
