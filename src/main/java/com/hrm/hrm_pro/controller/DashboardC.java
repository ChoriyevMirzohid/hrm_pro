package com.hrm.hrm_pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardC {

    @GetMapping("/dashboard")
    public String getPage(){
        return "index";
    }
}
