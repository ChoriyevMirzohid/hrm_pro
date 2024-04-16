package com.hrm.hrm_pro.service;

import com.hrm.hrm_pro.dto.EmpLevelDto;
import com.hrm.hrm_pro.dto.EmpPositionDto;
import com.hrm.hrm_pro.dto.PagingResponse;
import com.hrm.hrm_pro.model.system_emp.EmpLevel;
import com.hrm.hrm_pro.model.system_emp.EmpPosition;
import com.hrm.hrm_pro.repository.EmpPositionRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpPositionS {
    final EmpPositionRepo empPositionRepo;

    public EmpPositionS(EmpPositionRepo empPositionRepo) {
        this.empPositionRepo = empPositionRepo;
    }

    public List<EmpPositionDto> getAllEmpPosition(){
        return empPositionRepo.getAllEmpPosition();
    }

    public PagingResponse getAllEmpPositionPaging(int pageNum, int pageSize) {
        if (pageNum < 0){
            pageNum = 0;
        }
        if (pageSize <= 0){
            pageSize = 10;
        }
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<EmpPositionDto> empPositionPage = empPositionRepo.getAllEmpPositionPaging(pageable);
        List<?> empPositionList = empPositionPage.stream().toList();

        PagingResponse pagingResponse = new PagingResponse();
        pagingResponse.setContent(empPositionList);
        pagingResponse.setPageNum(empPositionPage.getNumber());
        pagingResponse.setPageSize(empPositionPage.getSize());
        pagingResponse.setTotalPages(empPositionPage.getTotalPages());
        pagingResponse.setTotalElements(empPositionPage.getTotalElements());
        pagingResponse.setLast(empPositionPage.isLast());

        return pagingResponse;
    }

    public void save(EmpPositionDto empPositionDto) {
        EmpPosition empPosition = new EmpPosition();
        empPosition.setCode(empPositionDto.getCode());
        empPosition.setName_uz(empPositionDto.getName_uz());
        empPosition.setName_ru(empPositionDto.getName_ru());
        empPosition.setName_en(empPositionDto.getName_en());
        empPosition.setCondition(empPositionDto.getCondition());

        empPositionRepo.save(empPosition);
    }
}
