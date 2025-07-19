package com.example.bankcards.service.impl;

import com.example.bankcards.entity.AccountUser;
import com.example.bankcards.exception.NotFoundException;
import com.example.bankcards.repository.AccountUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class AccountUserDetailService implements UserDetailsService {
    private final AccountUserRepo accountUserRepo;
    private final MessageSource messageSource;

    @Autowired
    public AccountUserDetailService(AccountUserRepo userAccountRepo, MessageSource messageSource) {
        this.accountUserRepo = userAccountRepo;
        this.messageSource = messageSource;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AccountUser user = accountUserRepo.findByEmail(email).orElseThrow(() ->  new NotFoundException(messageSource.getMessage(
                "error.account.user.not.found.email",
                new Object[]{email},
                Locale.getDefault())));

        return User.withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities(user.getRole().getName())
                .build();
    }
}
