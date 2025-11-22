package ru.ilinykh.testtaskstudents.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ilinykh.testtaskstudents.dto.GroupDto;
import ru.ilinykh.testtaskstudents.dto.StudentCreateDto;
import ru.ilinykh.testtaskstudents.dto.StudentDto;
import ru.ilinykh.testtaskstudents.service.GroupService;
import ru.ilinykh.testtaskstudents.service.StudentService;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final GroupService groupService;

    @PostMapping
    public String addStudent(@ModelAttribute StudentCreateDto studentCreateDto, Model model) {
        studentService.addStudent(studentCreateDto);

        GroupDto group = groupService.getGroupById(studentCreateDto.getGroupId());
        addAttributesToModel(model, group);

        return "redirect:/groups/" + studentCreateDto.getGroupId();
    }

    @PostMapping("/delete")
    public String deleteStudent(Model model, @RequestParam UUID studentId, @RequestParam UUID groupId) {
        studentService.deleteStudent(studentId);

        GroupDto group = groupService.getGroupById(groupId);
        addAttributesToModel(model, group);

        return "redirect:/groups/" + groupId;
    }

    private void addAttributesToModel(Model model, GroupDto group) {
        List<StudentDto> students = studentService.getStudentsByGroupId(group.getId());
        model.addAttribute("students", students);
        model.addAttribute("groupNumber", group.getNumber());
        model.addAttribute("groupId", group.getId());
        model.addAttribute("studentCreateDto", new StudentCreateDto());
    }
}
