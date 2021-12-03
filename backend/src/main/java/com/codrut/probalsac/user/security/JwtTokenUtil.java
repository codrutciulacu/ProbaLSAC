package com.codrut.probalsac.user.security;

import com.codrut.probalsac.user.domain.User;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenUtil {
    private final String jwtSecret = "zdtlD3JK56m6wTTgsNFhqzjqP";

    public String generateAccessToken(User user) {
        return Jwts.builder()
                .setSubject(String.format("%s,%s", user.getId(), user.getUsername()))
                .setIssuer("codrut.io")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000)) // 1 week
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserId(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject().split(",")[0];
    }

    public String getUsername(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject().split(",")[1];
    }

    public Date getExpirationDate(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getExpiration();
    }

    public boolean validate(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException ex) {
           throw new RuntimeException("Invalid JWT token", ex);
        } catch (ExpiredJwtException ex) {
            throw new RuntimeException("Expired JWT token", ex);
        } catch (UnsupportedJwtException ex) {
            throw new RuntimeException("Unsupported JWT token", ex);
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException("JWT claims string is empty", ex);
        }
    }
}
