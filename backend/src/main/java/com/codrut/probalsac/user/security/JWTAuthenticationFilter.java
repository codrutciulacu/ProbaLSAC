package com.codrut.probalsac.user.security;

import com.codrut.probalsac.user.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

        private final AuthenticationManager authenticationManager;
        private final JwtTokenUtil jwtTokenUtil;

        public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
            this.authenticationManager = authenticationManager;
            this.jwtTokenUtil = jwtTokenUtil;

            setFilterProcessesUrl("/api/v1/auth/login");
        }

        @Override
        public Authentication attemptAuthentication(HttpServletRequest req,
                                                    HttpServletResponse res) throws AuthenticationException {
            try {
                User creds = new ObjectMapper()
                        .readValue(req.getInputStream(), User.class);

                return authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                creds.getUsername(),
                                creds.getPassword(),
                                new ArrayList<>())
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        protected void successfulAuthentication(HttpServletRequest req,
                                                HttpServletResponse res,
                                                FilterChain chain,
                                                Authentication auth) throws IOException {
            String token = jwtTokenUtil.generateAccessToken((User) auth.getPrincipal());

            res.getWriter().write(token);
            res.getWriter().flush();
        }
    }

