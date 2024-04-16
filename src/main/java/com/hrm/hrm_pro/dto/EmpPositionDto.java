package com.hrm.hrm_pro.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Data
@NoArgsConstructor
public class EmpPositionDto {
    private Integer id;
    private String code;
    private String name_uz;
    private String name_ru;
    private String name_en;
    private String condition;
    private String create_date;
    private String delete_date;

    public EmpPositionDto(Integer id, String code, String name_uz, String name_ru, String name_en, String condition, Timestamp create_date, Timestamp delete_date) {
        this.id = id;
        this.code = code;
        this.name_uz = name_uz;
        this.name_ru = name_ru;
        this.name_en = name_en;
        this.condition = condition;
        this.create_date = new SimpleDateFormat("dd.MM.yyyy HH:mm").format(create_date);
        this.delete_date = delete_date != null ? (new SimpleDateFormat("dd.MM.yyyy HH:mm").format(delete_date)) : "";
    }
}
