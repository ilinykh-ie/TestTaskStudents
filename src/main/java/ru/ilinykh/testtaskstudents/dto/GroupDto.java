package ru.ilinykh.testtaskstudents.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GroupDto {
    private String number;
    private Integer studentsCount;
}
