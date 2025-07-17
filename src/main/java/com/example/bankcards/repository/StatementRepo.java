package com.example.bankcards.repository;

import com.example.bankcards.entity.Statement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatementRepo extends JpaRepository<Statement, Long> {
}
