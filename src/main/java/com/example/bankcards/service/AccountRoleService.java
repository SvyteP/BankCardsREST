package com.example.bankcards.service;

import com.example.bankcards.dto.AccountRoleGetDTO;
import com.example.bankcards.dto.base.ResponseDTO;

import java.util.List;


public interface AccountRoleService {
    ResponseDTO<List<AccountRoleGetDTO>> getRoles();
}
