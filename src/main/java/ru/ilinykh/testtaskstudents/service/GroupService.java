package ru.ilinykh.testtaskstudents.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ilinykh.testtaskstudents.dto.GroupDto;
import ru.ilinykh.testtaskstudents.mapper.GroupMapper;
import ru.ilinykh.testtaskstudents.repository.GroupRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    public List<GroupDto> getAllGroups() {
        return groupMapper.entityToDto(groupRepository.findAll());
    }
}
