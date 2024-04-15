package com.hrm.hrm_pro.controller;

import com.hrm.hrm_pro.dto.BankDepartmentDto;
import com.hrm.hrm_pro.model.system_emp.EmpCondition;
import com.hrm.hrm_pro.repository.EmpConditionRepo;
import com.hrm.hrm_pro.service.BankDepartmentS;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BankDepartmentC {
    final BankDepartmentS bankDepartmentS;
    final EmpConditionRepo empConditionRepo;

    public BankDepartmentC(BankDepartmentS bankDepartmentS, EmpConditionRepo empConditionRepo) {
        this.bankDepartmentS = bankDepartmentS;
        this.empConditionRepo = empConditionRepo;
    }

    @GetMapping("/bank-department")
    public String getPage(
            @RequestParam(value = "num", defaultValue = "0", required = false) int num,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            Model model){
        List<EmpCondition> conditionList = empConditionRepo.findAll();
        model.addAttribute("conditionList", conditionList);
        model.addAttribute("bankDirectorates", bankDepartmentS.getAllDirectorate());
        model.addAttribute("list", bankDepartmentS.getAllBankDepartmentPaging(num, size));
        return "bank-department";
    }

    @PostMapping("/bank-department/new")
    public String createUserReg(@ModelAttribute("bankDepartmentDto") BankDepartmentDto bankDepartmentDto){
        bankDepartmentS.save(bankDepartmentDto);
        return "redirect:/bank-department";
    }
}
