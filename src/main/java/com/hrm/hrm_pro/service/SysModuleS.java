package com.hrm.hrm_pro.service;

import com.hrm.hrm_pro.dto.PagingResponse;
import com.hrm.hrm_pro.dto.SysModuleDto;
import com.hrm.hrm_pro.dto.UserRegDto;
import com.hrm.hrm_pro.model.system_user.SysModule;
import com.hrm.hrm_pro.model.system_user.UserEntity;
import com.hrm.hrm_pro.repository.SysModuleRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SysModuleS {
    final SysModuleRepo sysModuleRepo;
    final UserRegS userRegS;

    public SysModuleS(SysModuleRepo sysModuleRepo, UserRegS userRegS) {
        this.sysModuleRepo = sysModuleRepo;
        this.userRegS = userRegS;
    }

    public List<SysModuleDto> getAllSysModule(String login){
        String user_role;
        UserRegDto user = userRegS.userRegRepo.getUserById(login);

        if (user.getRole_code().equals(3)){
            user_role="super_admin";
        }else{
            user_role="user_admin";
        }

        if (Objects.equals(user_role, "user_admin")){
            return sysModuleRepo.getAllSysModuleAdmin();
        }else{
            return sysModuleRepo.getAllSysModuleSAdmin();
        }
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
        sysModule.setPage_role(sysModuleDto.getPage_role());

        sysModuleRepo.save(sysModule);
    }
}
