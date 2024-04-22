package com.hrm.hrm_pro.service;

import com.hrm.hrm_pro.dto.BankBlockDto;
import com.hrm.hrm_pro.dto.PagingResponse;
import com.hrm.hrm_pro.dto.SysModuleDto;
import com.hrm.hrm_pro.model.system_emp.BankBlock;
import com.hrm.hrm_pro.model.system_user.SysModule;
import com.hrm.hrm_pro.repository.SysModuleRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public PagingResponse getAllSysModulePaging(int pageNum, int pageSize) {
        if (pageNum < 0){
            pageNum = 0;
        }
        if (pageSize <= 0){
            pageSize = 10;
        }
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<SysModuleDto> sysModulePage = sysModuleRepo.getAllSysModulePaging(pageable);
        List<?> sysModuleList = sysModulePage.stream().toList();

        PagingResponse pagingResponse = new PagingResponse();
        pagingResponse.setContent(sysModuleList);
        pagingResponse.setPageNum(sysModulePage.getNumber());
        pagingResponse.setPageSize(sysModulePage.getSize());
        pagingResponse.setTotalPages(sysModulePage.getTotalPages());
        pagingResponse.setTotalElements(sysModulePage.getTotalElements());
        pagingResponse.setLast(sysModulePage.isLast());

        return pagingResponse;
    }

    public void save(SysModuleDto sysModuleDto) {
        SysModule sysModule = new SysModule();
        sysModule.setCode(sysModuleDto.getCode());
        sysModule.setName_uz(sysModuleDto.getName_uz());
        sysModule.setName_ru(sysModuleDto.getName_ru());
        sysModule.setName_en(sysModuleDto.getName_en());
        sysModule.setCondition(sysModuleDto.getCondition());
        sysModule.setPage_icon(sysModuleDto.getPage_icon());
        sysModule.setPage_type(sysModuleDto.getPage_type());
        sysModule.setPage_url(sysModuleDto.getPage_url());

        sysModuleRepo.save(sysModule);
    }
}
