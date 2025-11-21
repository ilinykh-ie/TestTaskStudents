package ru.ilinykh.testtaskstudents.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ilinykh.testtaskstudents.service.GroupService;

@Controller
@RequestMapping("groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    public String getAllGroups(Model model) {
        model.addAttribute("groups", groupService.getAllGroups());

        return "groups";
    }
}
