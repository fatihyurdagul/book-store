package com.bookstore.restapi.util;

import com.bookstore.domain.CustomerDomain;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    public CustomerDomain parsedToken(String token) {
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            CustomerDomain u = new CustomerDomain();
            u.setUsername(body.getSubject());
            u.setId(Long.parseLong((String) body.get("userId")));

            return u;

        } catch (JwtException | ClassCastException e) {
            return null;
        }
    }


    public String generateToken(CustomerDomain u) {
        Claims claims = Jwts.claims().setSubject(u.getUsername());
        claims.put("userId", u.getId() + "");

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
