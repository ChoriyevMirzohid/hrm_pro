package com.hrm.hrm_pro.repository;

import com.hrm.hrm_pro.dto.BankBlockDto;
import com.hrm.hrm_pro.model.system_emp.BankBlock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankBlockRepo extends JpaRepository<BankBlock, Integer> {
    @Query("select new com.hrm.hrm_pro.dto.BankBlockDto(a.id, a.code, a.name_uz, a.name_ru, a.name_en, a.deputy_id, a.condition, a.create_date, a.delete_date) from BankBlock a order by a.create_date desc")
    Page<BankBlockDto> getAllBankBlockPaging(Pageable pageable);

    @Query("select new com.hrm.hrm_pro.dto.BankBlockDto(a.id, a.code, a.name_uz, a.name_ru, a.name_en, a.deputy_id, a.condition, a.create_date, a.delete_date) from BankBlock a where a.condition = '1' order by a.create_date desc")
    List<BankBlockDto> getAllBankBlock();
}
