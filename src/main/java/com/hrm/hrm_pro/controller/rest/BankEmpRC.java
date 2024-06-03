package com.hrm.hrm_pro.controller.rest;

import com.hrm.hrm_pro.common.EmpExportFile;
import com.hrm.hrm_pro.model.system_emp.BankEmp;
import com.hrm.hrm_pro.service.BankEmpS;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class BankEmpRC {
    final EmpExportFile empExportFile;
    final BankEmpS bankEmpS;

    public BankEmpRC(EmpExportFile empExportFile, BankEmpS bankEmpS) {
        this.empExportFile = empExportFile;
        this.bankEmpS = bankEmpS;
    }

    @GetMapping("/bank-emp-view/{emp_id}")
    public ResponseEntity<BankEmp> getEmployeeById(@PathVariable("emp_id") Integer emp_id){
        return ResponseEntity.ok().body(bankEmpS.getBankEmpById(emp_id));
    }
}
