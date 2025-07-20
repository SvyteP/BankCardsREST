package com.example.bankcards.service;

import com.example.bankcards.dto.AccountUserGetDTO;
import com.example.bankcards.dto.AccountUserRegDTO;
import com.example.bankcards.dto.base.RequestDTO;
import com.example.bankcards.dto.base.ResponseDTO;
import com.example.bankcards.entity.AccountUser;

import java.util.List;

public interface AccountUserService {
    ResponseDTO<AccountUserGetDTO> createAccountUser(RequestDTO<AccountUserRegDTO> regDTO);
    ResponseDTO<AccountUserGetDTO> getAccountUser(String token);
    ResponseDTO<List<AccountUserGetDTO>> getAllAccountUser(String token);
    ResponseDTO<AccountUserGetDTO> updateAccountUser(RequestDTO<AccountUserRegDTO> regDTO);
    ResponseDTO<AccountUserGetDTO> deleteAccountUser(String token);
    ResponseDTO<AccountUserGetDTO> changeRole(String token);

}
