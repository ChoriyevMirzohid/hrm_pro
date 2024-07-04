package com.hrm.hrm_pro.repository;

import com.hrm.hrm_pro.dto.BankDirectorateDto;
import com.hrm.hrm_pro.model.system_emp.BankDirectorate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BankDirectorateRepo extends JpaRepository<BankDirectorate, Integer> {
    @Query("select new com.hrm.hrm_pro.dto.BankDirectorateDto(a.id, a.code, a.block_id, a.name_uz, a.name_ru, a.name_en, a.deputy_id, a.condition, a.create_date, a.delete_date) from BankDirectorate a where a.block_id=:block_id order by a.id")
    Page<BankDirectorateDto> getAllBankDirectoratePaging(Pageable pageable, Integer block_id);

    @Query("select new com.hrm.hrm_pro.dto.BankDirectorateDto(a.id, a.code, a.block_id, a.name_uz, a.name_ru, a.name_en, a.deputy_id, a.condition, a.create_date, a.delete_date) from BankDirectorate a order by a.id")
    Page<BankDirectorateDto> getAllBankDirectoratePaging(Pageable pageable);

    @Query("select new com.hrm.hrm_pro.dto.BankDirectorateDto(a.id, a.code, a.block_id, a.name_uz, a.name_ru, a.name_en, a.deputy_id, a.condition, a.create_date, a.delete_date) from BankDirectorate a where a.condition='1' order by a.id")
    List<BankDirectorateDto> getAllBankDirectorate();

    @Query("select new com.hrm.hrm_pro.dto.BankDirectorateDto(a.id, a.code, a.block_id, a.name_uz, a.name_ru, a.name_en, a.deputy_id, a.condition, a.create_date, a.delete_date) from BankDirectorate a where a.id=:id and a.condition='1' order by a.id")
    BankDirectorateDto getBankDirectorateById(Integer id);

    @Query("select count(a) from BankDirectorate a where a.condition='1'")
    int getDirecCount();
}
