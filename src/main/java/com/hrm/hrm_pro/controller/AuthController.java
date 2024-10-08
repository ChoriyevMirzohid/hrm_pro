package com.hrm.hrm_pro.controller;

import com.hrm.hrm_pro.dto.LoginDto;
import com.hrm.hrm_pro.service.AuthService;
import com.hrm.hrm_pro.service.SysModuleS;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    final AuthService authService;
    final SysModuleS sysModuleS;

    public AuthController(AuthService authService, SysModuleS sysModuleS) {
        this.authService = authService;
        this.sysModuleS = sysModuleS;
    }

    @GetMapping("/login")
    public String getPage(){
        return "login";
    }

    @PostMapping("/auth/login")
    public String login(Model model, @ModelAttribute("loginDto") LoginDto loginDto, HttpSession session){
        boolean check = authService.loginPasswordCheck(loginDto.getLogin(), loginDto.getPassword());
        String returnStr = null;
        if (check){
            session.setAttribute("username", loginDto.getLogin());
            session.setAttribute("systems", sysModuleS.getAllSysModule(loginDto.getLogin()));
            session.setAttribute("login_status", "1");
            returnStr = "redirect:/dashboard";
        }else {
            session.setAttribute("login_status", "-1");
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
