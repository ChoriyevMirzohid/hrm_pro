package com.hrm.hrm_pro.controller;

import com.hrm.hrm_pro.common.RedirectLogin;
import com.hrm.hrm_pro.service.BankBlockS;
import com.hrm.hrm_pro.service.BankDepartmentS;
import com.hrm.hrm_pro.service.BankDirectorateS;
import com.hrm.hrm_pro.service.BankEmpS;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardC {
    final BankEmpS bankEmpS;
    final BankBlockS bankBlockS;
    final BankDirectorateS bankDirectorateS;
    final BankDepartmentS bankDepartmentS;

    public DashboardC(BankEmpS bankEmpS, BankBlockS bankBlockS, BankDirectorateS bankDirectorateS, BankDepartmentS bankDepartmentS) {
        this.bankEmpS = bankEmpS;
        this.bankBlockS = bankBlockS;
        this.bankDirectorateS = bankDirectorateS;
        this.bankDepartmentS = bankDepartmentS;
    }

    @GetMapping("/dashboard")
    public String getPage(HttpSession httpSession, Model model){
        model.addAttribute("empCount", bankEmpS.getEmpCount());
        model.addAttribute("blockCount", bankBlockS.getBlockCount());
        model.addAttribute("direcCount", bankDirectorateS.getDirecCount());
        model.addAttribute("departCount", bankDepartmentS.getDepartCount());
        return RedirectLogin.redirectLogin("index", httpSession);
    }
}
