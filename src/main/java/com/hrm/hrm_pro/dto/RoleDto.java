package com.hrm.hrm_pro.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoleDto {
    private Integer id;
    private Integer code;
    private String name;
    private String title;

    public RoleDto(Integer id, Integer code, String name, String title) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.title = title;
    }
}
