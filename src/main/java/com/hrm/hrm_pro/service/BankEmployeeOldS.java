package com.hrm.hrm_pro.service;

import com.hrm.hrm_pro.dto.BankBlockDto;
import com.hrm.hrm_pro.dto.PagingResponse;
import com.hrm.hrm_pro.model.system_emp.BankEmployeeOld;
import com.hrm.hrm_pro.repository.BankEmployeeOldRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class BankEmployeeOldS {
    final BankEmployeeOldRepo bankEmployeeOldRepo;

    public BankEmployeeOldS(BankEmployeeOldRepo bankEmployeeOldRepo) {
        this.bankEmployeeOldRepo = bankEmployeeOldRepo;
    }

    public PagingResponse getAllBankEmpOldPaging(int pageNum, int pageSize) {
        if (pageNum < 0){
            pageNum = 0;
        }
        if (pageSize <= 0){
            pageSize = 10;
        }
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<BankEmployeeOld> bankEmpPage = bankEmployeeOldRepo.getAllBankEmpOldPaging(pageable);
        List<?> bankEmpList = bankEmpPage.stream().toList();

        PagingResponse pagingResponse = new PagingResponse();
        pagingResponse.setContent(bankEmpList);
        pagingResponse.setPageNum(bankEmpPage.getNumber());
        pagingResponse.setPageSize(bankEmpPage.getSize());
        pagingResponse.setTotalPages(bankEmpPage.getTotalPages());
        pagingResponse.setTotalElements(bankEmpPage.getTotalElements());
        pagingResponse.setLast(bankEmpPage.isLast());

        return pagingResponse;
    }

    public void saveToDatabase(MultipartFile file){
        if(ExcelUploadService.isValidExcelFile(file)){
            try {
                List<BankEmployeeOld> bankEmployeeOldList = ExcelUploadService.getDataFromExcel(file.getInputStream());
                bankEmployeeOldRepo.saveAll(bankEmployeeOldList);
            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not a valid excel file");
            }
        }
    }
}
