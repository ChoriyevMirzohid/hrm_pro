package com.hrm.hrm_pro.controller.rest;

import com.hrm.hrm_pro.dto.BankBlockDto;
import com.hrm.hrm_pro.service.BankBlockS;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/bank-block")
public class BankBlockRC {
    final BankBlockS bankBlockS;

    public BankBlockRC(BankBlockS bankBlockS) {
        this.bankBlockS = bankBlockS;
    }

    @GetMapping("/block-all")
    public ResponseEntity<List<BankBlockDto>> getBlockAll(){
        return ResponseEntity.ok().body(bankBlockS.getAllBankBlock());
    }
}
