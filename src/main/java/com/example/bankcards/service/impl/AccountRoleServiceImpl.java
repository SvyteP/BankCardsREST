package com.example.bankcards.service.impl;

import com.example.bankcards.dto.AccountRoleGetDTO;
import com.example.bankcards.dto.base.ResponseDTO;
import com.example.bankcards.entity.AccountRole;
import com.example.bankcards.repository.AccountRoleRepo;
import com.example.bankcards.service.AccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountRoleServiceImpl implements AccountRoleService {
    AccountRoleRepo accountRoleRepo;

    @Autowired
    public AccountRoleServiceImpl(AccountRoleRepo accountRoleRepo) {
        this.accountRoleRepo = accountRoleRepo;
    }

    @Override
    public ResponseDTO<List<AccountRoleGetDTO>> getRoles() {
        return new ResponseDTO<>(
                accountRoleRepo.findAll().stream().map(AccountRoleGetDTO::new).collect(Collectors.toCollection(ArrayList::new))
        );
    }
}
