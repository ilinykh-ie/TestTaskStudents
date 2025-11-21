package ru.ilinykh.testtaskstudents.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.ilinykh.testtaskstudents.dto.GroupDto;
import ru.ilinykh.testtaskstudents.entity.GroupEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GroupMapper {

    @Mapping(target = "studentsCount", expression = "java(groupEntity.getStudents().size())")
    GroupDto entityToDto(GroupEntity groupEntity);

    List<GroupDto> entityToDto(List<GroupEntity> groupEntities);
}
