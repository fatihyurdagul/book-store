package com.bookstore.restapi.config.security.filter;

import com.bookstore.restapi.config.security.token.JwtAuthenticationToken;
import com.bookstore.restapi.exception.JwtTokenMissingException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public JwtAuthenticationFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager) {
        super(defaultFilterProcessesUrl);
        this.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer "))
            throw new JwtTokenMissingException("No JWT token found in request headers");

        String authToken = header.substring(7);
        JwtAuthenticationToken authRequest = new JwtAuthenticationToken(authToken, null);

        return getAuthenticationManager().authenticate(authRequest);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);

        chain.doFilter(request, response);
    }
}