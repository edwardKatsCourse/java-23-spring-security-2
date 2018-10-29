package com.example.securitydemo;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecurityFilter extends OncePerRequestFilter {

    private static final String VALID_TOKEN = "valid_token";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        String header = httpServletRequest.getHeader("Authorization");
        if (header != null) {
            if (header.equals(VALID_TOKEN)) {
                //Authentication
                String usernameFromHeader = httpServletRequest.getHeader("username");
                if (usernameFromHeader == null) {
                    usernameFromHeader = "unknown user";
                }

                String roleName = httpServletRequest.getHeader("role");

                List<GrantedAuthority> roles = new ArrayList<>();
                if (roleName != null) {
                    roles.add(new SimpleGrantedAuthority(roleName));
                }

                Authentication permission = new UsernamePasswordAuthenticationToken(
                        usernameFromHeader,
                        null,
                        roles
                );

                SecurityContextHolder.getContext().setAuthentication(permission);
            }
        }


        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
