package com.example.bankcards.entity;

import jakarta.persistence.*;
import lombok.Data;

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
    private Date registrationDate;

}
