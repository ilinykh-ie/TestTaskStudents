package ru.ilinykh.testtaskstudents.mapper;

import org.mapstruct.Mapper;
import ru.ilinykh.testtaskstudents.dto.StudentDto;
import ru.ilinykh.testtaskstudents.entity.StudentEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDto entityToDto(StudentEntity entity);

    List<StudentDto> entitiesToDto(List<StudentEntity> entities);
}
