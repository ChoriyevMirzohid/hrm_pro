package com.hrm.hrm_pro.service;

import com.hrm.hrm_pro.dto.BankDepartmentDto;
import com.hrm.hrm_pro.dto.BankDirectorateDto;
import com.hrm.hrm_pro.dto.PagingResponse;
import com.hrm.hrm_pro.model.system_emp.BankDepartment;
import com.hrm.hrm_pro.repository.BankDepartmentRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankDepartmentS {
    final BankDepartmentRepo bankDepartmentRepo;
    final BankDirectorateS bankDirectorateS;

    public BankDepartmentS(BankDepartmentRepo bankDepartmentRepo, BankDirectorateS bankDirectorateS) {
        this.bankDepartmentRepo = bankDepartmentRepo;
        this.bankDirectorateS = bankDirectorateS;
    }

    public List<BankDepartmentDto> getAllBankDepartment(){
        return bankDepartmentRepo.getAllBankDepartment();
    }

    public List<BankDirectorateDto> getAllDirectorate(){
        return bankDirectorateS.getAllBankDirectorate();
    }

    public PagingResponse getAllBankDepartmentPaging(int pageNum, int pageSize) {
        if (pageNum < 0){
            pageNum = 0;
        }
        if (pageSize <= 0){
            pageSize = 10;
        }
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<BankDepartmentDto> bankDepartmentPage = bankDepartmentRepo.getAllBankDepartmentPaging(pageable);
        List<?> bankDirectorateList = bankDepartmentPage.stream().toList();

        PagingResponse pagingResponse = new PagingResponse();
        pagingResponse.setContent(bankDirectorateList);
        pagingResponse.setPageNum(bankDepartmentPage.getNumber());
        pagingResponse.setPageSize(bankDepartmentPage.getSize());
        pagingResponse.setTotalPages(bankDepartmentPage.getTotalPages());
        pagingResponse.setTotalElements(bankDepartmentPage.getTotalElements());
        pagingResponse.setLast(bankDepartmentPage.isLast());

        return pagingResponse;
    }

    public void save(BankDepartmentDto bankDepartmentDto) {
        BankDepartment bankDepartment = new BankDepartment();
        bankDepartment.setCode(bankDepartmentDto.getCode());
        bankDepartment.setDirectorate_id(bankDepartmentDto.getDirectorate_id());
        bankDepartment.setName_uz(bankDepartmentDto.getName_uz());
        bankDepartment.setName_ru(bankDepartmentDto.getName_ru());
        bankDepartment.setName_en(bankDepartmentDto.getName_en());
        bankDepartment.setDeputy_id(bankDepartmentDto.getDeputy_id());
        bankDepartment.setCondition(bankDepartmentDto.getCondition());

        bankDepartmentRepo.save(bankDepartment);
    }
}
