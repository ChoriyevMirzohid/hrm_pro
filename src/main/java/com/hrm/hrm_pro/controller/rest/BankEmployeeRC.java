package com.hrm.hrm_pro.controller.rest;

import com.hrm.hrm_pro.dto.BankEmpDto;
import com.hrm.hrm_pro.model.system_emp.BankEmp;
import com.hrm.hrm_pro.service.BankEmpS;
import com.hrm.hrm_pro.service.BankEmployeeS;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankEmployeeRC {
    final BankEmpS bankEmployeeOldS;
    final BankEmployeeS bankEmployeeS;

    public BankEmployeeRC(BankEmpS bankEmployeeOldS, BankEmployeeS bankEmployeeS) {
        this.bankEmployeeOldS = bankEmployeeOldS;
        this.bankEmployeeS = bankEmployeeS;
    }

    @GetMapping("/bank-employee-old/{emp_id}")
    public ResponseEntity<BankEmp> getEmployeeById(@PathVariable("emp_id") Integer emp_id){
        return ResponseEntity.ok().body(bankEmployeeOldS.getBankEmployeeById(emp_id));
    }
}
