package com.hrm.hrm_pro.controller;

import com.hrm.hrm_pro.dto.EmpLevelDto;
import com.hrm.hrm_pro.dto.EmpPositionDto;
import com.hrm.hrm_pro.model.system_emp.EmpCondition;
import com.hrm.hrm_pro.repository.EmpConditionRepo;
import com.hrm.hrm_pro.service.EmpPositionS;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmpPositionC {
    final EmpPositionS empPositionS;
    final EmpConditionRepo empConditionRepo;

    public EmpPositionC(EmpPositionS empPositionS, EmpConditionRepo empConditionRepo) {
        this.empPositionS = empPositionS;
        this.empConditionRepo = empConditionRepo;
    }

    @GetMapping("/bank-emp-position")
    public String getPage(
            @RequestParam(value = "num", defaultValue = "0", required = false) int num,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            Model model){
        List<EmpCondition> conditionList = empConditionRepo.findAll();
        model.addAttribute("conditionList", conditionList);
        model.addAttribute("list", empPositionS.getAllEmpPositionPaging(num, size));
        return "bank-emp-position";
    }

    @PostMapping("/bank-emp-position/new")
    public String save(@ModelAttribute("empPositionDto") EmpPositionDto empPositionDto){
        empPositionS.save(empPositionDto);
        return "redirect:/bank-emp-position";
    }
}
