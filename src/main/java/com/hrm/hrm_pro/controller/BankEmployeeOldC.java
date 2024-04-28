package com.hrm.hrm_pro.controller;

import com.hrm.hrm_pro.common.RedirectLogin;
import com.hrm.hrm_pro.model.system_emp.EmpCondition;
import com.hrm.hrm_pro.repository.EmpConditionRepo;
import com.hrm.hrm_pro.service.BankEmployeeOldS;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class BankEmployeeOldC {
    final BankEmployeeOldS bankEmployeeOldS;
    final EmpConditionRepo empConditionRepo;

    public BankEmployeeOldC(BankEmployeeOldS bankEmployeeOldS, EmpConditionRepo empConditionRepo) {
        this.bankEmployeeOldS = bankEmployeeOldS;
        this.empConditionRepo = empConditionRepo;
    }

    @GetMapping("/bank-emp-old")
    public String getPage(
            @RequestParam(value = "num", defaultValue = "0", required = false) int num,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            @RequestParam(value = "filter", defaultValue = "", required = false) String filter,
            Model model,
            HttpSession session){
        if (session != null){
            List<EmpCondition> conditionList = empConditionRepo.findAll();
            model.addAttribute("conditionList", conditionList);
            model.addAttribute("filter", filter);
            model.addAttribute("list", bankEmployeeOldS.getAllBankEmpOldPaging(num, size, filter));
        }
        return RedirectLogin.redirectLogin("bank-emp-old", session);
    }

    @PostMapping("/bank-emp-old/import")
    public String uploadData(@RequestParam("file") MultipartFile file){
        bankEmployeeOldS.saveToDatabase(file);
        return "redirect:/bank-emp-old";
    }
}
