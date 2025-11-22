package ru.ilinykh.testtaskstudents.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class StudentCreateDto {
    private String firstName;
    private String lastName;
    private String middleName;
    private UUID groupId;
}
