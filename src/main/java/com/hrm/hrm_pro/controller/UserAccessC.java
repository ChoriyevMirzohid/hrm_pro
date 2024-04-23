package com.hrm.hrm_pro.controller;

import com.hrm.hrm_pro.common.RedirectLogin;
import com.hrm.hrm_pro.service.UserAccessS;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserAccessC {
    final UserAccessS userAccessS;

    public UserAccessC(UserAccessS userAccessS) {
        this.userAccessS = userAccessS;
    }

    @GetMapping("/user-access-module/{id}")
    public String getPage(@PathVariable Integer id, Model model, HttpSession httpSession){
        return RedirectLogin.redirectLogin("user-access-module", httpSession);
    }
}
