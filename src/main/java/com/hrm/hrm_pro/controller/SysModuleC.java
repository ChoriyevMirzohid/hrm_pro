package com.hrm.hrm_pro.controller;

import com.hrm.hrm_pro.service.SysModuleS;
import org.springframework.stereotype.Controller;

@Controller
public class SysModuleC {
    final SysModuleS sysModuleS;

    public SysModuleC(SysModuleS sysModuleS) {
        this.sysModuleS = sysModuleS;
    }
}
