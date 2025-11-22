package ru.ilinykh.testtaskstudents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ilinykh.testtaskstudents.entity.StudentEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {

    List<StudentEntity> findAllByGroupIdOrderByLastNameAsc(UUID groupId);
}
