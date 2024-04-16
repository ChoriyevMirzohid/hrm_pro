package com.hrm.hrm_pro.repository;

import com.hrm.hrm_pro.dto.EmpLevelDto;
import com.hrm.hrm_pro.dto.EmpPositionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpPositionRepo extends JpaRepository<EmpPositionDto, Integer> {
    @Query("select new com.hrm.hrm_pro.dto.EmpPositionDto(a.id, a.code, a.name_uz, a.name_ru, a.name_en, a.condition, a.create_date, a.delete_date) from EmpPosition a order by a.create_date desc")
    Page<EmpLevelDto> getAllEmpPositionPaging(Pageable pageable);

    @Query("select new com.hrm.hrm_pro.dto.EmpPositionDto(a.id, a.code, a.name_uz, a.name_ru, a.name_en, a.condition, a.create_date, a.delete_date) from EmpPosition a order by a.id")
    List<EmpLevelDto> getAllEmpPosition();
}
