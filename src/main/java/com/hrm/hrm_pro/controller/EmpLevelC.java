package com.hrm.hrm_pro.controller;

import com.hrm.hrm_pro.common.RedirectLogin;
import com.hrm.hrm_pro.dto.BankDepartmentDto;
import com.hrm.hrm_pro.dto.EmpLevelDto;
import com.hrm.hrm_pro.model.system_emp.EmpCondition;
import com.hrm.hrm_pro.repository.EmpConditionRepo;
import com.hrm.hrm_pro.service.EmpLevelS;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmpLevelC {
    final EmpLevelS empLevelS;
    final EmpConditionRepo empConditionRepo;

    public EmpLevelC(EmpLevelS empLevelS, EmpConditionRepo empConditionRepo) {
        this.empLevelS = empLevelS;
        this.empConditionRepo = empConditionRepo;
    }

    @GetMapping("/bank-emp-level")
    public String getPage(
            @RequestParam(value = "num", defaultValue = "0", required = false) int num,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            Model model,
            HttpSession httpSession){
        List<EmpCondition> conditionList = empConditionRepo.findAll();
        model.addAttribute("conditionList", conditionList);
        model.addAttribute("list", empLevelS.getAllEmpLevelPaging(num, size));
        return RedirectLogin.redirectLogin( "bank-emp-level", httpSession);
    }

    @PostMapping("/bank-emp-level/new")
    public String save(@ModelAttribute("bankDepartmentDto") EmpLevelDto empLevelDto){
        empLevelS.save(empLevelDto);
        return "redirect:/bank-emp-level";
    }
}
