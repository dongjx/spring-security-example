package com.springsecurityexample.service;

import com.springsecurityexample.model.User;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtTokenService {

    private final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    public String generateToken(Authentication authentication) {
        User user = (User)authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(expireDate())
                .signWith(signatureAlgorithm, jwtSecret)
                .compact();
    }

    public String parseToken(String authToken) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(authToken)
                .getBody();
        return String.valueOf(claims.getSubject());
    }

    private Date expireDate() {
        Date ExpireDate = new Date(new Date().getTime() + jwtExpirationInMs);
        return ExpireDate;
    }
}
