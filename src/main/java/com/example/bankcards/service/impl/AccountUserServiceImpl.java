package com.example.bankcards.service.impl;

import com.example.bankcards.dto.AccountUserGetDTO;
import com.example.bankcards.dto.AccountUserRegDTO;
import com.example.bankcards.dto.base.RequestDTO;
import com.example.bankcards.dto.base.ResponseDTO;
import com.example.bankcards.entity.AccountRole;
import com.example.bankcards.entity.AccountStatus;
import com.example.bankcards.entity.AccountUser;
import com.example.bankcards.repository.AccountRoleRepo;
import com.example.bankcards.repository.AccountStatusRepo;
import com.example.bankcards.repository.AccountUserRepo;
import com.example.bankcards.security.jwt.JwtUtils;
import com.example.bankcards.service.AccountUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountUserServiceImpl implements AccountUserService {
    private final AccountUserRepo accountUserRepo;
    private final AccountRoleRepo accountRoleRepo;
    private final AccountStatusRepo accountStatusRepo;
    private final PasswordEncoder passwordEncoder;
    private final MessageSource messageSource;
    private final JwtUtils jwtUtils;

    @Autowired
    public AccountUserServiceImpl(AccountUserRepo accountUserRepo, AccountRoleRepo accountRoleRepo, AccountStatusRepo accountStatusRepo, PasswordEncoder passwordEncoder, MessageSource messageSource, JwtUtils jwtUtils) {
        this.accountUserRepo = accountUserRepo;
        this.accountRoleRepo = accountRoleRepo;
        this.accountStatusRepo = accountStatusRepo;
        this.passwordEncoder = passwordEncoder;
        this.messageSource = messageSource;
        this.jwtUtils = jwtUtils;
    }

    @Override
    @Transactional
    public ResponseDTO<AccountUserGetDTO> createAccountUser(RequestDTO<AccountUserRegDTO> regDTO) {
        if (regDTO == null){
            throw new NullPointerException();
        }
        AccountUserRegDTO accountUserRegDTO = regDTO.requestBody();

        AccountRole role = accountRoleRepo.findById(accountUserRegDTO.role()).orElseThrow();
        AccountStatus status = accountStatusRepo.findById(accountUserRegDTO.status()).orElseThrow();

        AccountUser accountUser = new AccountUser(
                accountUserRegDTO,
                role,
                status,
                passwordEncoder.encode(accountUserRegDTO.password()));
        accountUserRepo.save(accountUser);

        return new ResponseDTO<>(new AccountUserGetDTO(accountUser));
    }

    @Override
    public ResponseDTO<AccountUserGetDTO> getAccountUser() {

        return null;
    }

    @Override
    public ResponseDTO<List<AccountUserGetDTO>> getAllAccountUser() {
        return null;
    }

    @Override
    public ResponseDTO<AccountUserGetDTO> updateAccountUser(RequestDTO<AccountUserRegDTO> regDTO) {
        return null;
    }

    @Override
    public ResponseDTO<AccountUserGetDTO> deleteAccountUser() {
        return null;
    }

    @Override
    public ResponseDTO<AccountUserGetDTO> changeRole() {
        return null;
    }
}
