package ru.ilinykh.testtaskstudents.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class StudentDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate receiptDate;
}
