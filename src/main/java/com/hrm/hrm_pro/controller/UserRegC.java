package com.hrm.hrm_pro.controller;

import com.hrm.hrm_pro.dto.UserRegDto;
import com.hrm.hrm_pro.model.system_user.UserCondition;
import com.hrm.hrm_pro.repository.UserConditionRepo;
import com.hrm.hrm_pro.service.UserRegS;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserRegC {
    final
    UserConditionRepo conditionRepo;
    final UserRegS userRegS;

    public UserRegC(UserConditionRepo conditionRepo, UserRegS userRegS) {
        this.conditionRepo = conditionRepo;
        this.userRegS = userRegS;
    }

    @GetMapping("/user-register")
    public String getPageEdit(
            @RequestParam(value = "pageNum", defaultValue = "0", required = false) int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            Model model){
        List<UserCondition> conditionList = conditionRepo.findAll();
        model.addAttribute("conditionList", conditionList);
        model.addAttribute("users", userRegS.getAllUsersPaging(pageNum, pageSize));
        return "user-reg";
    }

    @PostMapping("/user-register/new")
    public String createUserReg(@ModelAttribute("userReg") UserRegDto userRegDto){
        userRegS.save(userRegDto);
        return "redirect:/user-register";
    }
}
