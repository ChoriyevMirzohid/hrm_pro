package com.hrm.hrm_pro.controller;

import com.hrm.hrm_pro.common.RedirectLogin;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardC {
    @GetMapping("/dashboard")
    public String getPage(HttpSession httpSession){
        return RedirectLogin.redirectLogin("index", httpSession);
    }
}
