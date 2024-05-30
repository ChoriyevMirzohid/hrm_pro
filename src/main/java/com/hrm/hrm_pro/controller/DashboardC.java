package com.hrm.hrm_pro.controller;

import com.hrm.hrm_pro.common.RedirectLogin;
import com.hrm.hrm_pro.repository.EmpConditionRepo;
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
    final EmpConditionRepo empConditionRepo;

    public DashboardC(BankEmpS bankEmpS, BankBlockS bankBlockS, BankDirectorateS bankDirectorateS, BankDepartmentS bankDepartmentS, EmpConditionRepo empConditionRepo) {
        this.bankEmpS = bankEmpS;
        this.bankBlockS = bankBlockS;
        this.bankDirectorateS = bankDirectorateS;
        this.bankDepartmentS = bankDepartmentS;
        this.empConditionRepo = empConditionRepo;
    }

    @GetMapping("/dashboard")
    public String getPage(HttpSession httpSession, Model model){
        model.addAttribute("empCount", bankEmpS.getEmpCount());
        model.addAttribute("blockCount", bankBlockS.getBlockCount());
        model.addAttribute("direcCount", bankDirectorateS.getDirecCount());
        model.addAttribute("departCount", bankDepartmentS.getDepartCount());
        model.addAttribute("blockList", bankBlockS.getAllBankBlockPaging(0, 10));
        model.addAttribute("conditionList", empConditionRepo.findAll());
        return RedirectLogin.redirectLogin("index", httpSession);
    }
}
