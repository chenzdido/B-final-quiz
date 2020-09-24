package com.example.demo.api;

import com.example.demo.domain.Groups;
import com.example.demo.domain.Trainee;
import com.example.demo.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
@CrossOrigin("http://localhost:1234")
public class GroupController {
    private final GroupService groupService;
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("")
    public List<Groups> getAllGroups(){
        return groupService.getAllGroups();
    }

    @PostMapping("/auto-grouping")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Groups> autoGrouping(){
        return groupService.autoGrouping();
    }
}
