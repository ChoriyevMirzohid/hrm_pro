package com.hrm.hrm_pro.controller;

import com.hrm.hrm_pro.common.RedirectLogin;
import com.hrm.hrm_pro.dto.EmpPositionDto;
import com.hrm.hrm_pro.dto.SysModuleDto;
import com.hrm.hrm_pro.model.system_user.UserCondition;
import com.hrm.hrm_pro.repository.UserConditionRepo;
import com.hrm.hrm_pro.service.SysModuleS;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SysModuleC {
    final SysModuleS sysModuleS;
    final UserConditionRepo userConditionRepo;

    public SysModuleC(SysModuleS sysModuleS, UserConditionRepo userConditionRepo) {
        this.sysModuleS = sysModuleS;
        this.userConditionRepo = userConditionRepo;
    }

    @GetMapping("/sys-module")
    public String getPage(
            @RequestParam(value = "num", defaultValue = "0", required = false) int num,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            Model model,
            HttpSession httpSession){
        List<UserCondition> conditionList = userConditionRepo.findAll();
        model.addAttribute("conditionList", conditionList);
        model.addAttribute("list", sysModuleS.getAllSysModulePaging(num, size));
        return RedirectLogin.redirectLogin("sys-module", httpSession);
    }

    @PostMapping("/sys-module/new")
    public String save(@ModelAttribute("sysModuleDto") SysModuleDto sysModuleDto){
        sysModuleS.save(sysModuleDto);
        return "redirect:/sys-module";
    }
}
