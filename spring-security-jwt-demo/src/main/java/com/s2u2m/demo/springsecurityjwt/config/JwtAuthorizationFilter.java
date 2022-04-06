package com.s2u2m.demo.springsecurityjwt.config;

import com.s2u2m.demo.springsecurityjwt.domain.UserInfo;
import com.s2u2m.demo.springsecurityjwt.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    public static final String HEADER_KEY = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    private JwtService jwtService;

    public JwtAuthorizationFilter(
            AuthenticationManager authenticationManager,
            JwtService jwtService) {
        super(authenticationManager);
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal
            (HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String token = request.getHeader(HEADER_KEY);
        if (!StringUtils.hasText(token) || !token.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        token = token.replace(TOKEN_PREFIX, "").trim();
        UserInfo userInfo = jwtService.verify(token);
        // TODO: get authorities
        Collection<GrantedAuthority> authorities = Collections.emptyList();

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                userInfo.getName(), null, authorities);
        authenticationToken.setDetails(userInfo);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }
}
