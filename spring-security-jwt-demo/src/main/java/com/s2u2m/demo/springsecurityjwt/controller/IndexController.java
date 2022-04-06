package com.s2u2m.demo.springsecurityjwt.controller;

import com.s2u2m.demo.springsecurityjwt.domain.UserInfo;
import com.s2u2m.demo.springsecurityjwt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class IndexController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public String loginSuccess(Authentication authentication) throws IOException {
        var name = authentication.getName();

        UserInfo userInfo = new UserInfo();
        userInfo.setUid("1");
        userInfo.setName(name);
        return jwtService.generateToken(userInfo);
    }

    @GetMapping("")
    public UserInfo getUserInfo(Authentication authentication) {
        return (UserInfo) authentication.getDetails();
    }
}
