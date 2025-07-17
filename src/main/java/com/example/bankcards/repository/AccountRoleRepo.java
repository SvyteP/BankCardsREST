package com.example.bankcards.repository;

import com.example.bankcards.entity.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRoleRepo extends JpaRepository<AccountRole,Long> {
}
