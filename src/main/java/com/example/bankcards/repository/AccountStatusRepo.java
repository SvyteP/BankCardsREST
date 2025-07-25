package com.example.bankcards.repository;

import com.example.bankcards.entity.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountStatusRepo extends JpaRepository<AccountStatus, Long> {
}
