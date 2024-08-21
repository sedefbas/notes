package com.sedef.notes.Dto;


import lombok.Data;


@Data
public class ActivityResponse {

    private int id;

    private String header;

    private String description;

    private int categoryId;
}
