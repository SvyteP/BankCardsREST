package com.example.bankcards.entity;

import com.example.bankcards.dto.AccountUserRegDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "accounts")
public class AccountUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "username")
    private String userName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_role_id")
    private AccountRole role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_status_id")
    private AccountStatus accountStatus;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    public AccountUser() {
    }

    public AccountUser(AccountUserRegDTO regDTO, AccountRole role, AccountStatus status, String password) {
        this.userName = regDTO.userName();
        this.fullName = regDTO.fullName();
        this.email = regDTO.email();
        this.password = password;
        this.role = role;
        this.accountStatus = status;
        this.registrationDate = LocalDate.now();
    }
}
