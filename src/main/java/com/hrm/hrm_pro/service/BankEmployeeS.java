package com.hrm.hrm_pro.service;

import com.hrm.hrm_pro.dto.BankEmployeeDto;
import com.hrm.hrm_pro.dto.PagingResponse;
import com.hrm.hrm_pro.model.system_emp.BankEmployee;
import com.hrm.hrm_pro.repository.BankEmployeeRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class BankEmployeeS {
    final BankEmployeeRepo bankEmployeeRepo;
    final BankBlockS bankBlockS;
    final BankDirectorateS bankDirectorateS;
    final BankDepartmentS bankDepartmentS;

    public BankEmployeeS(BankEmployeeRepo bankEmployeeRepo, BankBlockS bankBlockS, BankDirectorateS bankDirectorateS, BankDepartmentS bankDepartmentS) {
        this.bankEmployeeRepo = bankEmployeeRepo;
        this.bankBlockS = bankBlockS;
        this.bankDirectorateS = bankDirectorateS;
        this.bankDepartmentS = bankDepartmentS;
    }

    public List<BankEmployeeDto> getBankEmployeeList(){
        return bankEmployeeRepo.getBankEmployeeList();
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

    public void save(BankEmployeeDto bankEmployeeDto) {
        BankEmployee bankEmployee = new BankEmployee();
        bankEmployee.setFirstname(bankEmployeeDto.getFirstname());
        bankEmployee.setLastname(bankEmployeeDto.getLastname());
        bankEmployee.setPatronymic(bankEmployeeDto.getPatronymic());
        bankEmployee.setBlock_id(bankEmployeeDto.getBlock_id());
        bankEmployee.setDirectorate_id(bankEmployeeDto.getDirectorate_id());
        bankEmployee.setDepartment_id(bankEmployeeDto.getDepartment_id());
        bankEmployee.setEmployment_date(Date.valueOf(bankEmployeeDto.getEmployment_date()));
        bankEmployee.setLevel_id(bankEmployeeDto.getLevel_id());
        bankEmployee.setPosition_id(bankEmployeeDto.getPosition_id());
        bankEmployee.setCondition(bankEmployeeDto.getCondition());

        bankEmployee.setShort_name(bankEmployeeDto.getFirstname().toUpperCase().charAt(0) + "." + bankEmployeeDto.getPatronymic().toUpperCase().charAt(0) + "." +
                bankEmployeeDto.getLastname());

        String block_code = bankBlockS.getBankBlockById(bankEmployeeDto.getBlock_id()).getCode();
        String direc_code = bankDirectorateS.getBankDirectorateById(bankEmployeeDto.getDirectorate_id()).getCode();
        String depart_code = bankDepartmentS.getBankDepartmentById(bankEmployeeDto.getDepartment_id()).getCode();
        String emp_depart_code = block_code + "-" + direc_code + "-" + depart_code;
        bankEmployee.setEmp_depart_code(emp_depart_code);

        bankEmployeeRepo.save(bankEmployee);
    }

    public void update(BankEmployeeDto bankEmployeeDto, Integer empId) {
        BankEmployee bankEmployee = bankEmployeeRepo.findById(empId).get();
        bankEmployee.setFirstname(bankEmployeeDto.getFirstname());
        bankEmployee.setLastname(bankEmployeeDto.getLastname());
        bankEmployee.setPatronymic(bankEmployeeDto.getPatronymic());
        bankEmployee.setBlock_id(bankEmployeeDto.getBlock_id());
        bankEmployee.setDirectorate_id(bankEmployeeDto.getDirectorate_id());
        bankEmployee.setDepartment_id(bankEmployeeDto.getDepartment_id());
        bankEmployee.setEmployment_date(Date.valueOf(bankEmployeeDto.getEmployment_date()));
        bankEmployee.setLevel_id(bankEmployeeDto.getLevel_id());
        bankEmployee.setPosition_id(bankEmployeeDto.getPosition_id());
        bankEmployee.setCondition(bankEmployeeDto.getCondition());

        bankEmployee.setShort_name(bankEmployeeDto.getFirstname().toUpperCase().charAt(0) + "." + bankEmployeeDto.getPatronymic().toUpperCase().charAt(0) + "." +
                bankEmployeeDto.getLastname());

        String block_code = bankBlockS.getBankBlockById(bankEmployeeDto.getBlock_id()).getCode();
        String direc_code = bankDirectorateS.getBankDirectorateById(bankEmployeeDto.getDirectorate_id()).getCode();
        String depart_code = bankDepartmentS.getBankDepartmentById(bankEmployeeDto.getDepartment_id()).getCode();
        String emp_depart_code = block_code + "-" + direc_code + "-" + depart_code;
        bankEmployee.setEmp_depart_code(emp_depart_code);

        bankEmployeeRepo.save(bankEmployee);
    }
}
