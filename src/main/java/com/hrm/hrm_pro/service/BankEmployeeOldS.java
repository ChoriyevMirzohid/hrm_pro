package com.hrm.hrm_pro.service;

import com.hrm.hrm_pro.model.system_emp.BankEmployeeOld;
import com.hrm.hrm_pro.repository.BankEmployeeOldRepo;
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
