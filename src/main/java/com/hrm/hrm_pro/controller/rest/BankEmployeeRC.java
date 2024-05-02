package com.hrm.hrm_pro.controller.rest;

import com.hrm.hrm_pro.model.system_emp.BankEmployeeOld;
import com.hrm.hrm_pro.service.BankEmployeeOldS;
import com.hrm.hrm_pro.service.BankEmployeeS;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankEmployeeRC {
    final BankEmployeeOldS bankEmployeeOldS;
    final BankEmployeeS bankEmployeeS;

    public BankEmployeeRC(BankEmployeeOldS bankEmployeeOldS, BankEmployeeS bankEmployeeS) {
        this.bankEmployeeOldS = bankEmployeeOldS;
        this.bankEmployeeS = bankEmployeeS;
    }

    @GetMapping("/bank-employee-old/{emp_id}")
    public ResponseEntity<BankEmployeeOld> getEmployeeById(@PathVariable("emp_id") Integer emp_id){
        return ResponseEntity.ok().body(bankEmployeeOldS.getBankEmployeeById(emp_id));
    }
}
