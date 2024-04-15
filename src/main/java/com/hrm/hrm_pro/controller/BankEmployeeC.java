package com.hrm.hrm_pro.controller;

import com.hrm.hrm_pro.dto.BankEmployeeDto;
import com.hrm.hrm_pro.model.system_emp.EmpCondition;
import com.hrm.hrm_pro.repository.EmpConditionRepo;
import com.hrm.hrm_pro.service.BankBlockS;
import com.hrm.hrm_pro.service.BankEmployeeS;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BankEmployeeC {
    final BankEmployeeS bankEmployeeS;
    final EmpConditionRepo empConditionRepo;
    final BankBlockS bankBlockS;

    public BankEmployeeC(BankEmployeeS bankEmployeeS, EmpConditionRepo empConditionRepo, BankBlockS bankBlockS) {
        this.bankEmployeeS = bankEmployeeS;
        this.empConditionRepo = empConditionRepo;
        this.bankBlockS = bankBlockS;
    }

    @GetMapping("/bank-employee")
    public String getPage(
            @RequestParam(value = "num", defaultValue = "0", required = false) int num,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            Model model){
        List<EmpCondition> conditionList = empConditionRepo.findAll();
        model.addAttribute("conditionList", conditionList);
        model.addAttribute("bankBlocks", bankBlockS.getAllBankBlock());
        model.addAttribute("list", bankEmployeeS.getAllBankEmployeePaging(num, size));
        return "bank-employee";
    }
}
