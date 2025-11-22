package ru.ilinykh.testtaskstudents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ilinykh.testtaskstudents.entity.GroupEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, UUID> {
    List<GroupEntity> findAllByOrderByCreatedAtDesc();
}
