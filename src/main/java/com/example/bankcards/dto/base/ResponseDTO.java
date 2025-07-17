package com.example.bankcards.dto.base;

import java.time.LocalDateTime;

public record ResponseDTO<T>(T data, LocalDateTime dateTime) {
    public ResponseDTO (T data){
        this(data,LocalDateTime.now());
    }
}
