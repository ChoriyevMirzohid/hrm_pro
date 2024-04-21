package com.hrm.hrm_pro.controller;

import com.hrm.hrm_pro.common.RedirectLogin;
import com.hrm.hrm_pro.dto.UserRegDto;
import com.hrm.hrm_pro.model.system_user.UserCondition;
import com.hrm.hrm_pro.repository.UserConditionRepo;
import com.hrm.hrm_pro.service.UserRegS;
import jakarta.servlet.http.HttpSession;
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
            @RequestParam(value = "num", defaultValue = "0", required = false) int num,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            Model model,
            HttpSession httpSession){
        List<UserCondition> conditionList = conditionRepo.findAll();
        model.addAttribute("conditionList", conditionList);
        model.addAttribute("roleList", userRegS.getAllRole());
        model.addAttribute("list", userRegS.getAllUsersPaging(num, size));
        return RedirectLogin.redirectLogin( "user-reg", httpSession);
    }

    @PostMapping("/user-register/new")
    public String createUserReg(@ModelAttribute("userReg") UserRegDto userRegDto){
        userRegS.save(userRegDto);
        return "redirect:/user-register";
    }

    @GetMapping("/profile")
    public String getPageProfile(Model model, HttpSession httpSession){
        if (httpSession.getAttribute("username") != null){
            model.addAttribute("itemData", userRegS.getUserById(httpSession.getAttribute("username").toString()));
        }else{
            return "redirect:/login";
        }
        model.addAttribute("roleList", userRegS.getAllRole());
        model.addAttribute("conditionList", conditionRepo.findAll());
        return RedirectLogin.redirectLogin("profile", httpSession);
    }
}
