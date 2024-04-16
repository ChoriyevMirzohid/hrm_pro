package com.hrm.hrm_pro.service;

import com.hrm.hrm_pro.dto.BankDirectorateDto;
import com.hrm.hrm_pro.dto.BankEmployeeDto;
import com.hrm.hrm_pro.dto.PagingResponse;
import com.hrm.hrm_pro.repository.BankEmployeeRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankEmployeeS {
    final BankEmployeeRepo bankEmployeeRepo;

    public BankEmployeeS(BankEmployeeRepo bankEmployeeRepo) {
        this.bankEmployeeRepo = bankEmployeeRepo;
    }

    public PagingResponse getAllBankEmployeePaging(int pageNum, int pageSize) {
        if (pageNum < 0){
            pageNum = 0;
        }
        if (pageSize <= 0){
            pageSize = 10;
        }
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<BankEmployeeDto> bankEmployeePage = bankEmployeeRepo.getAllBankEmployeePaging(pageable);
        List<?> bankEmployeeList = bankEmployeePage.stream().toList();

        PagingResponse pagingResponse = new PagingResponse();
        pagingResponse.setContent(bankEmployeeList);
        pagingResponse.setPageNum(bankEmployeePage.getNumber());
        pagingResponse.setPageSize(bankEmployeePage.getSize());
        pagingResponse.setTotalPages(bankEmployeePage.getTotalPages());
        pagingResponse.setTotalElements(bankEmployeePage.getTotalElements());
        pagingResponse.setLast(bankEmployeePage.isLast());

        return pagingResponse;
    }

    public BankEmployeeDto getBankEmployeeById(Integer id) {
        return bankEmployeeRepo.getBankEmployeeById(id);
    }
}
