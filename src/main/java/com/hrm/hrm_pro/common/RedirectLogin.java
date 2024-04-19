package com.hrm.hrm_pro.common;

import jakarta.servlet.http.HttpSession;

public class RedirectLogin {
    public static String redirectLogin(String page, HttpSession httpSession){
        if (httpSession.getAttribute("username") != null){
            return page;
        }else {
            return "redirect:/login";
        }
    }
}
