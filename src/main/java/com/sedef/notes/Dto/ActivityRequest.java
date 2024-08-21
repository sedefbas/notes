package com.sedef.notes.Dto;

import com.sedef.notes.Model.Category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ActivityRequest {

    private String header;

    private String description;

    private int categoryId;
}
