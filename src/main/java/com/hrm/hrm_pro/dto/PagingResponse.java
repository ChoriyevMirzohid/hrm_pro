package com.hrm.hrm_pro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PagingResponse {
    private List<?> content;
    private int pageNum;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
