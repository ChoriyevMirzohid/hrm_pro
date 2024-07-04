package com.hrm.hrm_pro.controller;

import com.hrm.hrm_pro.common.RedirectLogin;
import com.hrm.hrm_pro.dto.BankDepartmentDto;
import com.hrm.hrm_pro.model.system_emp.EmpCondition;
import com.hrm.hrm_pro.repository.EmpConditionRepo;
import com.hrm.hrm_pro.service.BankBlockS;
import com.hrm.hrm_pro.service.BankDepartmentS;
import com.hrm.hrm_pro.service.BankDirectorateS;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BankDepartmentC {
    final BankDepartmentS bankDepartmentS;
    final EmpConditionRepo empConditionRepo;
    private final BankDirectorateS bankDirectorateS;
    private final BankBlockS bankBlockS;

    public BankDepartmentC(BankDepartmentS bankDepartmentS, EmpConditionRepo empConditionRepo, BankDirectorateS bankDirectorateS, BankBlockS bankBlockS) {
        this.bankDepartmentS = bankDepartmentS;
        this.empConditionRepo = empConditionRepo;
        this.bankDirectorateS = bankDirectorateS;
        this.bankBlockS = bankBlockS;
    }

    @GetMapping("/bank-department")
    public String getPage(
            @RequestParam(value = "num", defaultValue = "0", required = false) int num,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            Model model,
            HttpSession httpSession){
        List<EmpCondition> conditionList = empConditionRepo.findAll();
        model.addAttribute("conditionList", conditionList);
        model.addAttribute("bankDirectorates", bankDepartmentS.getAllDirectorate());
        model.addAttribute("bankDirectById", bankDirectorateS.getBankDirectorateById(0));
        model.addAttribute("list", bankDepartmentS.getAllBankDepartmentPaging(num, size, 0));
        return RedirectLogin.redirectLogin( "bank-department", httpSession);
    }

    @GetMapping("/bank-department-item/{id}")
    public String getPage(
            @RequestParam(value = "num", defaultValue = "0", required = false) int num,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            @PathVariable("id") Integer id,
            Model model,
            HttpSession httpSession){
        List<EmpCondition> conditionList = empConditionRepo.findAll();
        model.addAttribute("conditionList", conditionList);
        model.addAttribute("bankDirectorates", bankDepartmentS.getAllDirectorate());
        model.addAttribute("bankDirectById", bankDirectorateS.getBankDirectorateById(id));
        model.addAttribute("list", bankDepartmentS.getAllBankDepartmentPaging(num, size, id));
        return RedirectLogin.redirectLogin( "bank-department", httpSession);
    }

    @PostMapping("/bank-department/new")
    public String createUserReg(@ModelAttribute("bankDepartmentDto") BankDepartmentDto bankDepartmentDto){
        bankDepartmentS.save(bankDepartmentDto);
        return "redirect:/bank-department-item/" + bankDepartmentDto.getDirectorate_id();
    }
}
