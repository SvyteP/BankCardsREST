package com.example.bankcards.dto;

import com.example.bankcards.entity.AccountRole;

public record AccountRoleGetDTO(Long ID, String role) {
    public AccountRoleGetDTO(AccountRole accountRole) {
        this(accountRole.getID(),accountRole.getName());
    }
}
