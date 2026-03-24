package com.example.taskapp.mapper;

import com.example.taskapp.dto.PageResponse;
import org.springframework.data.domain.Page;

public class PageMapper<T> {

    public static <T> PageResponse<T> toPageResponse(Page<T> page) {
        return new PageResponse<T>(
                page.getContent(),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }
}