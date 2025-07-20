package com.example.bankcards.service;

import com.example.bankcards.dto.AccountUserGetDTO;
import com.example.bankcards.dto.AccountUserRegDTO;
import com.example.bankcards.dto.base.RequestDTO;
import com.example.bankcards.dto.base.ResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.stream.Stream;

@SpringBootTest
public class AccountUserTest {
    private final AccountUserService accountUserService;

    @Autowired
    public AccountUserTest(AccountUserService accountUserService) {
        this.accountUserService = accountUserService;
    }

    @ParameterizedTest
    @MethodSource({"getAccountUserData"})
    public void createUserTest(RequestDTO<AccountUserRegDTO> requestDTO,String role,
                               ResponseDTO<AccountUserGetDTO> expectedResponseDTO) {
        AccountUserGetDTO expectedDTO = expectedResponseDTO.data();

       AccountUserGetDTO result = accountUserService.createAccountUser(requestDTO).data();
       Assertions.assertEquals(expectedDTO, result);
    }

    public static Stream<Arguments> getAccountUserData() {
        AccountUserRegDTO accountUserRegDTO = new AccountUserRegDTO(
                "Ivan",
                "Ivanov Ivan Ivanovich",
                "Iva@mail.ru",
                "321",
                2L,
                2L
        );

        AccountUserGetDTO accountUserGetDTO = new AccountUserGetDTO(
                0L,
                "Ivan",
                "Ivanov Ivan Ivanovich",
                "Iva@mail.ru",
                "USER",
                "Active",
                LocalDate.now()
        );

        return Stream.of(
                Arguments.of(
                    new RequestDTO<>(accountUserRegDTO), new ResponseDTO<>(accountUserGetDTO)
                )
        );
    }
}
