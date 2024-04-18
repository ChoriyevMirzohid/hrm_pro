package com.hrm.hrm_pro.controller;

import com.hrm.hrm_pro.dto.LoginDto;
import com.hrm.hrm_pro.service.AuthService;
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
    public String login(@ModelAttribute("loginDto") LoginDto loginDto){
        boolean check = authService.loginPasswordCheck(loginDto.getLogin(), loginDto.getPassword());
        String returnStr = null;
        if (check){
            returnStr = "redirect:/dashboard";
        }else {
            returnStr = "redirect:/login";
        }
        return returnStr;
    }
}
