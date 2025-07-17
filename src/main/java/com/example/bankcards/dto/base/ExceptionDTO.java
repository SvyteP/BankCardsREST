package com.example.bankcards.dto.base;

import java.time.LocalDateTime;

public record ExceptionDTO(String message, String stackTrace, LocalDateTime dateTime) {
    public ExceptionDTO (String message, String stackTrace) {
        this(message, stackTrace, LocalDateTime.now());
    }
}
