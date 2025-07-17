package com.example.bankcards.repository;

import com.example.bankcards.entity.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountUserRepo extends JpaRepository<AccountUser, Long> {
    Optional<AccountUser> findByEmail(String email);
}
