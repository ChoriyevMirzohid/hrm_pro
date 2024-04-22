package com.hrm.hrm_pro.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Data
@NoArgsConstructor
public class SysModuleDto {
    private Integer id;
    private Integer code;
    private String name_uz;
    private String name_ru;
    private String name_en;
    private String page_url;
    private String page_icon;
    private String page_type;
    private String condition;
    private String create_date;

    public SysModuleDto(Integer id, Integer code, String name_uz, String name_ru, String name_en, String page_url, String page_icon, String page_type, String condition, Timestamp create_date) {
        this.id = id;
        this.code = code;
        this.name_uz = name_uz;
        this.name_ru = name_ru;
        this.name_en = name_en;
        this.page_url = page_url;
        this.page_icon = page_icon;
        this.page_type = page_type;
        this.condition = condition;
        this.create_date = new SimpleDateFormat("dd.MM.yyyy HH:mm").format(create_date);
    }
}
