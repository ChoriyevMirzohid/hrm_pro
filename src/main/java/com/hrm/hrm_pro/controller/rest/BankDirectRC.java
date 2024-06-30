package com.hrm.hrm_pro.controller.rest;

import com.hrm.hrm_pro.dto.BankBlockDto;
import com.hrm.hrm_pro.dto.BankDirectorateDto;
import com.hrm.hrm_pro.service.BankDirectorateS;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/bank-direct")
public class BankDirectRC {
    final BankDirectorateS bankDirectorateS;

    public BankDirectRC(BankDirectorateS bankDirectorateS) {
        this.bankDirectorateS = bankDirectorateS;
    }

    @GetMapping("/direct-all")
    public ResponseEntity<List<BankDirectorateDto>> getBlockAll(){
        return ResponseEntity.ok().body(bankDirectorateS.getAllBankDirectorate());
    }
}
