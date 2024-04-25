package com.hrm.hrm_pro.controller;

import com.hrm.hrm_pro.common.RedirectLogin;
import com.hrm.hrm_pro.service.BankEmployeeOldS;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BankEmployeeOldC {
    final BankEmployeeOldS bankEmployeeOldS;

    public BankEmployeeOldC(BankEmployeeOldS bankEmployeeOldS) {
        this.bankEmployeeOldS = bankEmployeeOldS;
    }

    @GetMapping("/bank-emp-old")
    public String getPage(HttpSession httpSession){
        return RedirectLogin.redirectLogin("bank-emp-old", httpSession);
    }

    @PostMapping("/bank-emp-old/import")
    public String uploadData(@RequestParam("file") MultipartFile file){
        bankEmployeeOldS.saveToDatabase(file);
        return "redirect:/bank-emp-old?status=true";
    }
}
