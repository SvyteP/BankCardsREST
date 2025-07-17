package com.example.bankcards.security.jwt;

import com.example.bankcards.entity.AccountUser;
import io.jsonwebtoken.Claims;

import java.util.Date;
import java.util.function.Function;

public interface JwtUtils {
    String generateToken(AccountUser user);
    String extractSubject(String token);
    long extractUserId(String token);
    Date extractIssuedAt(String token);
    Date extractExpiration(String token);
    <T> T extractClaim(String token, Function<Claims,T> funClaims);
    boolean isTokenExpired(String token);
}
