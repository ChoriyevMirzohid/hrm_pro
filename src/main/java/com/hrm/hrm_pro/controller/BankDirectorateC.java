package com.hrm.hrm_pro.controller;

import com.hrm.hrm_pro.dto.BankDirectorateDto;
import com.hrm.hrm_pro.model.system_emp.EmpCondition;
import com.hrm.hrm_pro.repository.EmpConditionRepo;
import com.hrm.hrm_pro.service.BankBlockS;
import com.hrm.hrm_pro.service.BankDirectorateS;
import com.hrm.hrm_pro.service.BankEmployeeS;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BankDirectorateC {
    final EmpConditionRepo empConditionRepo;
    final BankDirectorateS bankDirectorateS;
    final BankBlockS bankBlockS;
    final BankEmployeeS bankEmployeeS;

    public BankDirectorateC(EmpConditionRepo empConditionRepo, BankDirectorateS bankDirectorateS, BankBlockS bankBlockS, BankEmployeeS bankEmployeeS) {
        this.empConditionRepo = empConditionRepo;
        this.bankDirectorateS = bankDirectorateS;
        this.bankBlockS = bankBlockS;
        this.bankEmployeeS = bankEmployeeS;
    }

    @GetMapping("/bank-directorate")
    public String getPage(
            @RequestParam(value = "num", defaultValue = "0", required = false) int num,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            Model model){
        List<EmpCondition> conditionList = empConditionRepo.findAll();
        model.addAttribute("conditionList", conditionList);
        model.addAttribute("bankBlocks", bankBlockS.getAllBankBlock());
        model.addAttribute("employeeList", bankEmployeeS.getBankEmployeeList());
        model.addAttribute("list", bankDirectorateS.getAllBankBlockPaging(num, size));
        return "bank-directorate";
    }

    @PostMapping("/bank-directorate/new")
    public String createUserReg(@ModelAttribute("bankDirectorateDto") BankDirectorateDto bankDirectorateDto){
        bankDirectorateS.save(bankDirectorateDto);
        return "redirect:/bank-directorate";
    }
}
