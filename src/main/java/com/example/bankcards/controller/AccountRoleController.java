package com.example.bankcards.controller;

import com.example.bankcards.dto.base.ResponseDTO;
import com.example.bankcards.service.AccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/role")
public class AccountRoleController {
    private final AccountRoleService accountRoleService;

    @Autowired
    public AccountRoleController(AccountRoleService accountRoleService) {
        this.accountRoleService = accountRoleService;
    }

    @GetMapping
    public ResponseEntity<?> getAccountRoles() {
        return ResponseEntity.ok().body(accountRoleService.getRoles());
    }
}
