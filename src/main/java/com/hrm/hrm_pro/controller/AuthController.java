package com.hrm.hrm_pro.controller;

import com.hrm.hrm_pro.dto.LoginDto;
import com.hrm.hrm_pro.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String getPage(){
        return "login";
    }

    @PostMapping("/auth/login")
    public String login(@ModelAttribute("loginDto") LoginDto loginDto, HttpSession session){
        boolean check = authService.loginPasswordCheck(loginDto.getLogin(), loginDto.getPassword());
        String returnStr = null;
        if (check){
            session.setAttribute("username", loginDto.getLogin());
            returnStr = "redirect:/dashboard";
        }else {
            returnStr = "redirect:/login";
        }
        return returnStr;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }
}
