package com.hrm.hrm_pro.service;

import com.hrm.hrm_pro.dto.BankDepartmentDto;
import com.hrm.hrm_pro.dto.EmpLevelDto;
import com.hrm.hrm_pro.dto.PagingResponse;
import com.hrm.hrm_pro.model.system_emp.BankDepartment;
import com.hrm.hrm_pro.model.system_emp.EmpLevel;
import com.hrm.hrm_pro.repository.EmpLevelRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpLevelS {
    final EmpLevelRepo empLevelRepo;

    public EmpLevelS(EmpLevelRepo empLevelRepo) {
        this.empLevelRepo = empLevelRepo;
    }

    public List<EmpLevelDto> getAllEmpLevel(){
        return empLevelRepo.getAllEmpLevel();
    }

    public PagingResponse getAllEmpLevelPaging(int pageNum, int pageSize) {
        if (pageNum < 0){
            pageNum = 0;
        }
        if (pageSize <= 0){
            pageSize = 10;
        }
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<EmpLevelDto> empLevelPage = empLevelRepo.getAllEmpLevelPaging(pageable);
        List<?> empLevelList = empLevelPage.stream().toList();

        PagingResponse pagingResponse = new PagingResponse();
        pagingResponse.setContent(empLevelList);
        pagingResponse.setPageNum(empLevelPage.getNumber());
        pagingResponse.setPageSize(empLevelPage.getSize());
        pagingResponse.setTotalPages(empLevelPage.getTotalPages());
        pagingResponse.setTotalElements(empLevelPage.getTotalElements());
        pagingResponse.setLast(empLevelPage.isLast());

        return pagingResponse;
    }

    public void save(EmpLevelDto empLevelDto) {
        EmpLevel empLevel = new EmpLevel();
        empLevel.setLevel_code(empLevelDto.getLevel_code());
        empLevel.setName_uz(empLevelDto.getName_uz());
        empLevel.setName_ru(empLevelDto.getName_ru());
        empLevel.setName_en(empLevelDto.getName_en());
        empLevel.setCondition(empLevelDto.getCondition());

        empLevelRepo.save(empLevel);
    }
}
