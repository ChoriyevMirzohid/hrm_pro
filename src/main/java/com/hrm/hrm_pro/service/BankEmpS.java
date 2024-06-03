package com.hrm.hrm_pro.service;

import com.hrm.hrm_pro.dto.BankEmpDto;
import com.hrm.hrm_pro.dto.PagingResponse;
import com.hrm.hrm_pro.model.system_emp.BankEmp;
import com.hrm.hrm_pro.repository.BankEmpRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@Service
public class BankEmpS {
    final BankEmpRepo bankEmpRepo;
    final BankBlockS bankBlockS;
    final BankDirectorateS bankDirectorateS;
    final BankDepartmentS bankDepartmentS;

    public BankEmpS(BankEmpRepo bankEmpRepo, BankBlockS bankBlockS, BankDirectorateS bankDirectorateS, BankDepartmentS bankDepartmentS) {
        this.bankEmpRepo = bankEmpRepo;
        this.bankBlockS = bankBlockS;
        this.bankDirectorateS = bankDirectorateS;
        this.bankDepartmentS = bankDepartmentS;
    }

    public PagingResponse getAllBankEmpPaging(int pageNum, int pageSize, String filter) {
        if (pageNum < 0){
            pageNum = 0;
        }
        if (pageSize <= 0){
            pageSize = 10;
        }
        if (filter.isEmpty()){
            filter = "F";
        }else {
            filter = filter.toLowerCase();
        }
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<BankEmp> bankEmpPage;
        bankEmpPage = bankEmpRepo.getAllBankEmpPaging(pageable, filter);
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
                List<BankEmp> bankEmployeeOldList = ExcelUploadService.getDataFromExcel(file.getInputStream());
                bankEmpRepo.saveAll(bankEmployeeOldList);
            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not a valid excel file");
            }
        }
    }

    public BankEmp getBankEmpById(Integer emp_id) {
        return bankEmpRepo.getBankEmpById(emp_id);
    }

    public BankEmp saveBankEmployee(BankEmpDto bankEmpDto) {
        BankEmp bankEmp = new BankEmp();
        bankEmp.setNumber(1);
        bankEmp.setBank_block(bankEmpDto.getBank_block());
        bankEmp.setBank_direct(bankEmpDto.getBank_direct());
        bankEmp.setBank_dep(bankEmpDto.getBank_dep());
        bankEmp.setBank_dep_insade(bankEmpDto.getBank_dep_insade());
        bankEmp.setEmp_position(bankEmpDto.getEmp_position());
        bankEmp.setEmp_level(bankEmpDto.getEmp_level());
        bankEmp.setEmp_manager(bankEmpDto.getEmp_manager());
        bankEmp.setSub_employee(bankEmpDto.getSub_employee());
        bankEmp.setLevel_require(bankEmpDto.getLevel_require());
        bankEmp.setEmp_skill(bankEmpDto.getEmp_skill());
        bankEmp.setMain_obligation(bankEmpDto.getMain_obligation());
        bankEmp.setFunc_desc(bankEmpDto.getFunc_desc());
        bankEmp.setResponsibility(bankEmpDto.getResponsibility());
        bankEmp.setEmp_law(bankEmpDto.getEmp_law());

        bankEmp.setConf_direct_man1(bankEmpDto.getConf_direct_man1());
        bankEmp.setConf_direct_man2(bankEmpDto.getConf_direct_man2());
        bankEmp.setConf_direct_man3(bankEmpDto.getConf_direct_man3());
        bankEmp.setConf_direct_man4(bankEmpDto.getConf_direct_man4());

        bankEmp.setFirstname(bankEmpDto.getFirstname());
        bankEmp.setLastname(bankEmpDto.getLastname());
        bankEmp.setPatronymic(bankEmpDto.getPatronymic());

        bankEmp.setCondition("1");
        bankEmp.setCreation_type("create");

        String block_code = bankEmpDto.getBank_block();
        String direc_code = bankEmpDto.getBank_direct();
        String depart_code = bankEmpDto.getBank_dep();
        String unique_code = block_code + "/" + direc_code + "/" + depart_code;
        bankEmp.setCode_unique(unique_code);

        bankEmp = bankEmpRepo.save(bankEmp);
        return bankEmp;
    }

    public int getEmpCount(){
        return bankEmpRepo.getEmpCount();
    }
}
