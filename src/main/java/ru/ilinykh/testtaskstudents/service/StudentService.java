package ru.ilinykh.testtaskstudents.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ilinykh.testtaskstudents.dto.StudentCreateDto;
import ru.ilinykh.testtaskstudents.dto.StudentDto;
import ru.ilinykh.testtaskstudents.entity.GroupEntity;
import ru.ilinykh.testtaskstudents.entity.StudentEntity;
import ru.ilinykh.testtaskstudents.mapper.StudentMapper;
import ru.ilinykh.testtaskstudents.repository.GroupRepository;
import ru.ilinykh.testtaskstudents.repository.StudentRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final GroupRepository groupRepository;

    public List<StudentDto> getStudentsByGroupId(UUID groupId) {
        return studentMapper.entitiesToDto(studentRepository.findAllByGroupIdOrderByLastNameAsc(groupId));
    }

    @Transactional
    public void addStudent(StudentCreateDto studentDto) {
        GroupEntity groupEntity = groupRepository.findById(studentDto.getGroupId()).orElseThrow();

        StudentEntity studentEntity = new StudentEntity().setGroup(groupEntity)
                .setFirstName(studentDto.getFirstName())
                .setLastName(studentDto.getLastName())
                .setMiddleName(studentDto.getMiddleName());

        studentRepository.save(studentEntity);
    }

    @Transactional
    public void deleteStudent(UUID studentId) {
        studentRepository.deleteById(studentId);
    }
}
