package com.hrm.hrm_pro.service;

import com.hrm.hrm_pro.dto.BankDirectorateDto;
import com.hrm.hrm_pro.dto.PagingResponse;
import com.hrm.hrm_pro.model.system_emp.BankDirectorate;
import com.hrm.hrm_pro.repository.BankDirectorateRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankDirectorateS {
    final BankDirectorateRepo bankDirectorateRepo;
    final BankBlockS bankBlockS;

    public BankDirectorateS(BankDirectorateRepo bankDirectorateRepo, BankBlockS bankBlockS) {
        this.bankDirectorateRepo = bankDirectorateRepo;
        this.bankBlockS = bankBlockS;
    }

    public List<BankDirectorateDto> getAllBankDirectorate(){
        return bankDirectorateRepo.getAllBankDirectorate();
    }

    public BankDirectorateDto getBankDirectorateById(Integer id){
        return bankDirectorateRepo.getBankDirectorateById(id);
    }

    public PagingResponse getAllBankBlockPaging(int pageNum, int pageSize) {
        if (pageNum < 0){
            pageNum = 0;
        }
        if (pageSize <= 0){
            pageSize = 10;
        }
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<BankDirectorateDto> bankDirectoratePage = bankDirectorateRepo.getAllBankDirectoratePaging(pageable);
        List<?> bankDirectorateList = bankDirectoratePage.stream().toList();

        PagingResponse pagingResponse = new PagingResponse();
        pagingResponse.setContent(bankDirectorateList);
        pagingResponse.setPageNum(bankDirectoratePage.getNumber());
        pagingResponse.setPageSize(bankDirectoratePage.getSize());
        pagingResponse.setTotalPages(bankDirectoratePage.getTotalPages());
        pagingResponse.setTotalElements(bankDirectoratePage.getTotalElements());
        pagingResponse.setLast(bankDirectoratePage.isLast());

        return pagingResponse;
    }

    public void save(BankDirectorateDto bankDirectorateDto) {
        BankDirectorate bankDirectorate = new BankDirectorate();
        bankDirectorate.setCode(bankDirectorateDto.getCode());
        bankDirectorate.setBlock_id(bankDirectorateDto.getBlock_id());
        bankDirectorate.setName_uz(bankDirectorateDto.getName_uz());
        bankDirectorate.setName_ru(bankDirectorateDto.getName_ru());
        bankDirectorate.setName_en(bankDirectorateDto.getName_en());
        bankDirectorate.setDeputy_id(bankDirectorateDto.getDeputy_id());
        bankDirectorate.setCondition(bankDirectorateDto.getCondition());

        bankDirectorateRepo.save(bankDirectorate);
    }
}
