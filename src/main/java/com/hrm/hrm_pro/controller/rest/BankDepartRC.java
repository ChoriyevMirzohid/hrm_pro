package com.hrm.hrm_pro.controller.rest;

import com.hrm.hrm_pro.dto.BankDepartmentDto;
import com.hrm.hrm_pro.service.BankDepartmentS;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/bank-depart")
public class BankDepartRC {
    final BankDepartmentS bankDepartmentS;

    public BankDepartRC(BankDepartmentS bankDepartmentS) {
        this.bankDepartmentS = bankDepartmentS;
    }

    @GetMapping("/depart-all")
    public ResponseEntity<List<BankDepartmentDto>> getBlockAll(){
        return ResponseEntity.ok().body(bankDepartmentS.getAllBankDepartment());
    }
}
