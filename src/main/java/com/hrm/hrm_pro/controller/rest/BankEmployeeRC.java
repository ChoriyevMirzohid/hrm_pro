package com.hrm.hrm_pro.controller.rest;

import com.hrm.hrm_pro.common.EmpExportFile;
import com.hrm.hrm_pro.dto.ExportIdDto;
import com.hrm.hrm_pro.model.system_emp.BankEmp;
import com.hrm.hrm_pro.service.BankEmpS;
import com.hrm.hrm_pro.service.BankEmployeeS;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BankEmployeeRC {
    final EmpExportFile empExportFile;
    final BankEmpS bankEmployeeOldS;
    final BankEmployeeS bankEmployeeS;

    public BankEmployeeRC(EmpExportFile empExportFile, BankEmpS bankEmployeeOldS, BankEmployeeS bankEmployeeS) {
        this.empExportFile = empExportFile;
        this.bankEmployeeOldS = bankEmployeeOldS;
        this.bankEmployeeS = bankEmployeeS;
    }

    @GetMapping("/bank-emp/{emp_id}")
    public ResponseEntity<BankEmp> getEmployeeById(@PathVariable("emp_id") Integer emp_id){
        return ResponseEntity.ok().body(bankEmployeeOldS.getBankEmployeeById(emp_id));
    }
}
