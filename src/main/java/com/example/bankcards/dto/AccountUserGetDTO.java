package com.example.bankcards.dto;

import com.example.bankcards.entity.AccountUser;

import java.time.LocalDate;
import java.util.Date;

public record AccountUserGetDTO(Long ID, String userName, String fullName, String email, String role, String status, LocalDate regDate) {
    public AccountUserGetDTO (AccountUser user){
        this(
                user.getID(),
                user.getUserName(),
                user.getFullName(),
                user.getEmail(),
                user.getRole().getName(),
                user.getAccountStatus().getName(),
                user.getRegistrationDate()
        );
    }
}
