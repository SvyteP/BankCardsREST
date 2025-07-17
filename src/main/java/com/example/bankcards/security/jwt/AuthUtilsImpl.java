package com.example.bankcards.security.jwt;

import com.example.bankcards.dto.AccountUserGetDTO;
import com.example.bankcards.dto.AuthDTO;
import com.example.bankcards.dto.base.ResponseDTO;
import com.example.bankcards.entity.AccountUser;
import com.example.bankcards.exception.NotFoundException;
import com.example.bankcards.repository.AccountUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class AuthUtilsImpl implements AuthUtils {
    private final AuthenticationManager authenticationManager;
    private final AccountUserRepo accountUserRepo;
    private final MessageSource messageSource;
    private final JwtUtils jwtUtils;

    @Autowired
    public AuthUtilsImpl(AuthenticationManager authenticationManager, AccountUserRepo userAccountRepo, MessageSource messageSource, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.accountUserRepo = userAccountRepo;
        this.messageSource = messageSource;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public ResponseDTO<AuthDTO> authenticationUser(String login, String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, password));

        AccountUser user = accountUserRepo.findByEmail(login).orElseThrow(() -> new NotFoundException(messageSource.getMessage(
                "error.user.account.not.found",
                new Object[]{"login " + login},
                Locale.getDefault())));

        String token = jwtUtils.generateToken(user);
        return new ResponseDTO<>(
                new AuthDTO(
                        new AccountUserGetDTO(user), token));
    }
}
