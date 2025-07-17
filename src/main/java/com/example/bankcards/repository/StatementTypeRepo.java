package com.example.bankcards.repository;

import com.example.bankcards.entity.StatementType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatementTypeRepo extends JpaRepository<StatementType, Long> {
}
