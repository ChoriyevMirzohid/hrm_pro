package com.hrm.hrm_pro.controller.rest;

import com.hrm.hrm_pro.dto.PagingResponse;
import com.hrm.hrm_pro.service.UserRegS;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegRC {
    final
    UserRegS userRegS;

    public UserRegRC(UserRegS userRegS) {
        this.userRegS = userRegS;
    }

    @GetMapping("/user-register/all")
    public PagingResponse getAllUser(
            @RequestParam(value = "pageNum", defaultValue = "0", required = false) int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ){
        return userRegS.getAllUsersPaging(pageNum, pageSize);
    }
}
