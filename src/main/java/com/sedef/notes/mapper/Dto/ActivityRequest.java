package com.sedef.notes.mapper.Dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ActivityRequest {

    private String header;
    private LocalDateTime startTime;
    private LocalDate date;
    private int categoryId;
    private int userId;
}
