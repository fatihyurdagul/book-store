package com.bookstore.restapi.config.security.provider;

import com.bookstore.domain.CustomerDomain;
import com.bookstore.restapi.config.security.UserPrincipal;
import com.bookstore.restapi.config.security.token.JwtAuthenticationToken;
import com.bookstore.restapi.exception.JwtTokenException;
import com.bookstore.restapi.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;


@RequiredArgsConstructor
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private final JwtUtil jwtUtil;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                  UsernamePasswordAuthenticationToken authToken) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authToken) throws AuthenticationException {
        JwtAuthenticationToken jwtToken = (JwtAuthenticationToken) authToken;
        String token = jwtToken.getToken();

        CustomerDomain parsedUser = jwtUtil.parsedToken(token);

        if (parsedUser == null) throw new JwtTokenException("Jwt token is not valid");

        return new UserPrincipal(parsedUser.getUsername());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
