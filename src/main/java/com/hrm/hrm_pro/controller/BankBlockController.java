package com.hrm.hrm_pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankBlockController {
    @GetMapping("/bank-block")
    public String getPage(){
        return "bank-block";
    }
}
