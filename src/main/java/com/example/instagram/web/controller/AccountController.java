package com.example.instagram.web.controller;

import com.example.instagram.service.UserService;
import com.example.instagram.web.dto.user.UserSignupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class AccountController {

    private final UserService userService;

    // 회원가입
    @PostMapping("/signup")
    public String signup(UserSignupDto userSignupDto) {
        if(userService.save(userSignupDto)) return "redirect:/login";
        return "redirect:/signup?error";
    }
}
