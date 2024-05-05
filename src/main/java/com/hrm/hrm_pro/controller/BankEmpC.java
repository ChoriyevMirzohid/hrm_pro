package com.hrm.hrm_pro.controller;

import com.hrm.hrm_pro.common.EmpExportFile;
import com.hrm.hrm_pro.common.RedirectLogin;
import com.hrm.hrm_pro.dto.BankEmpDto;
import com.hrm.hrm_pro.model.system_emp.BankEmp;
import com.hrm.hrm_pro.model.system_emp.EmpCondition;
import com.hrm.hrm_pro.repository.EmpConditionRepo;
import com.hrm.hrm_pro.service.*;
import com.hrm.hrm_pro.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Controller
public class BankEmpC {
    final BankEmpS bankEmpS;
    final EmpConditionRepo empConditionRepo;
    final BankBlockS bankBlockS;
    final BankDepartmentS bankDepartmentS;
    final BankDirectorateS bankDirectorateS;
    final EmpPositionS empPositionS;
    final EmpLevelS empLevelS;
    final EmpExportFile empExportFile;

    public BankEmpC(BankEmpS bankEmpS, EmpConditionRepo empConditionRepo, BankBlockS bankBlockS, BankDepartmentS bankDepartmentS, BankDirectorateS bankDirectorateS, EmpPositionS empPositionS, EmpLevelS empLevelS, EmpExportFile empExportFile) {
        this.bankEmpS = bankEmpS;
        this.empConditionRepo = empConditionRepo;
        this.bankBlockS = bankBlockS;
        this.bankDepartmentS = bankDepartmentS;
        this.bankDirectorateS = bankDirectorateS;
        this.empPositionS = empPositionS;
        this.empLevelS = empLevelS;
        this.empExportFile = empExportFile;
    }

    @GetMapping("/bank-emp")
    public String getPage(
            @RequestParam(value = "num", defaultValue = "0", required = false) int num,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            @RequestParam(value = "filter", defaultValue = "", required = false) String filter,
            Model model,
            HttpSession session){
        if (session != null){
            List<EmpCondition> conditionList = empConditionRepo.findAll();
            model.addAttribute("conditionList", conditionList);
            model.addAttribute("blockList", bankBlockS.getAllBankBlock());
            model.addAttribute("positionList", empPositionS.getAllEmpPosition());
            model.addAttribute("levelList", empLevelS.getAllEmpLevel());
            model.addAttribute("departmentList", bankDepartmentS.getAllBankDepartment());
            model.addAttribute("directorateList", bankDirectorateS.getAllBankDirectorate());
            model.addAttribute("curDate", Utils.getCurDate());
            model.addAttribute("filter", filter);
            model.addAttribute("list", bankEmpS.getAllBankEmpPaging(num, size, filter));
        }
        return RedirectLogin.redirectLogin("bank-emp", session);
    }

    @PostMapping("/bank-emp/new")
    public String save(@ModelAttribute("bankEmployeeDto") BankEmpDto bankEmpDto){
        BankEmp bankEmpR = bankEmpS.saveBankEmployee(bankEmpDto);
        return "redirect:/bank-emp";
    }

    @PostMapping("/bank-emp/import")
    public String uploadData(@RequestParam("file") MultipartFile file){
        bankEmpS.saveToDatabase(file);
        return "redirect:/bank-emp";
    }

    @GetMapping("/bank-emp/download/{emp_id}")
    public String downloadFile(@PathVariable Integer emp_id,
                               HttpServletRequest request, HttpServletResponse response){
        empExportFile.getDocFile(emp_id, request, response);
        return "bank-emp";
    }
}
