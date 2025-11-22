package ru.ilinykh.testtaskstudents.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ilinykh.testtaskstudents.dto.GroupDto;
import ru.ilinykh.testtaskstudents.entity.GroupEntity;
import ru.ilinykh.testtaskstudents.mapper.GroupMapper;
import ru.ilinykh.testtaskstudents.repository.GroupRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    public List<GroupDto> getAllGroups() {
        return groupMapper.entityToDto(groupRepository.findAllByOrderByCreatedAtDesc());
    }

    public GroupDto createGroup(String groupNumber) {
        GroupEntity group = groupRepository.save(new GroupEntity().setNumber(groupNumber));

        return groupMapper.entityToDto(group);
    }

    public GroupDto getGroupById(UUID id) {
        return groupMapper.entityToDto(groupRepository.findById(id).orElseThrow());
    }
}
