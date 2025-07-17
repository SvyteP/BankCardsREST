package com.example.bankcards.repository;

import com.example.bankcards.entity.StatementStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatementStatusRepo extends JpaRepository<StatementStatus, Long> {
}
