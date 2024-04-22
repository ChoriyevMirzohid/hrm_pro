package com.hrm.hrm_pro.service;

import com.hrm.hrm_pro.dto.SysModuleDto;
import com.hrm.hrm_pro.repository.SysModuleRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysModuleS {
    final SysModuleRepo sysModuleRepo;

    public SysModuleS(SysModuleRepo sysModuleRepo) {
        this.sysModuleRepo = sysModuleRepo;
    }

    public List<SysModuleDto> getAllSysModule(){
        return sysModuleRepo.getAllSysModule();
    }
}
