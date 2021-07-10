package com.bookstore.restapi.config;

import com.bookstore.restapi.config.security.filter.JwtAuthenticationFilter;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors()
                .and().authorizeRequests().antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                .anyRequest().permitAll();
//                .anyRequest().authenticated()
//                .and().addFilterAt(authenticationSecurityFilter(), BasicAuthenticationFilter.class);
    }

    private JwtAuthenticationFilter authenticationSecurityFilter() throws Exception {
        return new JwtAuthenticationFilter("/**", authenticationManager());
    }
}
