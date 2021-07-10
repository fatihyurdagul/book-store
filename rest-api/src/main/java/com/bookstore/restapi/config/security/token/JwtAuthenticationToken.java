package com.bookstore.restapi.config.security.token;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Getter
@Setter
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {
    private String token;

    public JwtAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
        this.token = principal.toString();
    }
}
