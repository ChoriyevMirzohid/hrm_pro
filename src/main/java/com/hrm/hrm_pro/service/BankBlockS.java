package com.hrm.hrm_pro.service;

import com.hrm.hrm_pro.dto.BankBlockDto;
import com.hrm.hrm_pro.dto.BankDirectorateDto;
import com.hrm.hrm_pro.dto.PagingResponse;
import com.hrm.hrm_pro.model.system_emp.BankBlock;
import com.hrm.hrm_pro.repository.BankBlockRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BankBlockS {
    final BankBlockRepo bankBlockRepo;

    public BankBlockS(BankBlockRepo bankBlockRepo) {
        this.bankBlockRepo = bankBlockRepo;
    }

    public List<BankBlockDto> getAllBankBlock(){
        return bankBlockRepo.getAllBankBlock();
    }

    public BankBlockDto getBankBlockById(Integer id){
        return bankBlockRepo.getBankBlockById(id);
    }

    public PagingResponse getAllBankBlockPaging(int pageNum, int pageSize) {
        if (pageNum < 0){
            pageNum = 0;
        }
        if (pageSize <= 0){
            pageSize = 10;
        }
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<BankBlockDto> bankBlockPage = bankBlockRepo.getAllBankBlockPaging(pageable);
        List<?> bankBlockList = bankBlockPage.stream().toList();

        PagingResponse pagingResponse = new PagingResponse();
        pagingResponse.setContent(bankBlockList);
        pagingResponse.setPageNum(bankBlockPage.getNumber());
        pagingResponse.setPageSize(bankBlockPage.getSize());
        pagingResponse.setTotalPages(bankBlockPage.getTotalPages());
        pagingResponse.setTotalElements(bankBlockPage.getTotalElements());
        pagingResponse.setLast(bankBlockPage.isLast());

        return pagingResponse;
    }

    public void save(BankBlockDto bankBlockDto) {
        BankBlock bankBlock = new BankBlock();
        bankBlock.setCode(bankBlockDto.getCode());
        bankBlock.setName_uz(bankBlockDto.getName_uz());
        bankBlock.setName_ru(bankBlockDto.getName_ru());
        bankBlock.setName_en(bankBlockDto.getName_en());
        bankBlock.setDeputy_id(bankBlockDto.getDeputy_id());
        bankBlock.setCondition(bankBlockDto.getCondition());

        bankBlockRepo.save(bankBlock);
    }

    public int getBlockCount(){
        return bankBlockRepo.getBlockCount();
    }
}
