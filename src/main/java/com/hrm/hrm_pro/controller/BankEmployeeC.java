package com.hrm.hrm_pro.controller;

import com.hrm.hrm_pro.model.system_emp.EmpCondition;
import com.hrm.hrm_pro.repository.EmpConditionRepo;
import com.hrm.hrm_pro.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BankEmployeeC {
    final BankEmployeeS bankEmployeeS;
    final EmpConditionRepo empConditionRepo;
    final BankBlockS bankBlockS;
    final BankDepartmentS bankDepartmentS;
    final BankDirectorateS bankDirectorateS;
    final EmpPositionS empPositionS;
    final EmpLevelS empLevelS;

    public BankEmployeeC(BankEmployeeS bankEmployeeS, EmpConditionRepo empConditionRepo, BankBlockS bankBlockS, BankDepartmentS bankDepartmentS, BankDirectorateS bankDirectorateS, EmpPositionS empPositionS, EmpLevelS empLevelS) {
        this.bankEmployeeS = bankEmployeeS;
        this.empConditionRepo = empConditionRepo;
        this.bankBlockS = bankBlockS;
        this.bankDepartmentS = bankDepartmentS;
        this.bankDirectorateS = bankDirectorateS;
        this.empPositionS = empPositionS;
        this.empLevelS = empLevelS;
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

    @GetMapping("/bank-employee/{id}")
    public String getPageItem(
            @PathVariable Integer id,
            Model model){
        List<EmpCondition> conditionList = empConditionRepo.findAll();
        model.addAttribute("blockList", bankBlockS.getAllBankBlock());
        model.addAttribute("departmentList", bankDepartmentS.getAllBankDepartment());
        model.addAttribute("directorateList", bankDirectorateS.getAllBankDirectorate());
        model.addAttribute("blockList", bankBlockS.getAllBankBlock());
        model.addAttribute("positionList", empPositionS.getAllEmpPosition());
        model.addAttribute("levelList", empLevelS.getAllEmpLevel());
        model.addAttribute("conditionList", conditionList);
        model.addAttribute("itemData", bankEmployeeS.getBankEmployeeById(id));
        return "bank-employee-item";
    }
}
