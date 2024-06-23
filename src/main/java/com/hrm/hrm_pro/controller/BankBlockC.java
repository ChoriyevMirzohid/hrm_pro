package com.hrm.hrm_pro.controller;

import com.hrm.hrm_pro.common.RedirectLogin;
import com.hrm.hrm_pro.dto.BankBlockDto;
import com.hrm.hrm_pro.model.system_emp.EmpCondition;
import com.hrm.hrm_pro.repository.EmpConditionRepo;
import com.hrm.hrm_pro.service.BankBlockS;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class BankBlockC {
    final BankBlockS bankBlockS;
    final EmpConditionRepo empConditionRepo;

    public BankBlockC(BankBlockS bankBlockS, EmpConditionRepo empConditionRepo) {
        this.bankBlockS = bankBlockS;
        this.empConditionRepo = empConditionRepo;
    }

    @GetMapping("/bank-block")
    public String getPageEdit(
            @RequestParam(value = "num", defaultValue = "0", required = false) int num,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            Model model,
            HttpSession session){
        List<EmpCondition> conditionList = empConditionRepo.findAll();
        model.addAttribute("conditionList", conditionList);
        model.addAttribute("list", bankBlockS.getAllBankBlockPaging(num, size));
        return RedirectLogin.redirectLogin("bank-block", session);
    }

    @PostMapping("/bank-block/new")
    public String createUserReg(@ModelAttribute("userReg") BankBlockDto bankBlockDto){
        bankBlockS.save(bankBlockDto);
        return "redirect:/bank-block";
    }
}
