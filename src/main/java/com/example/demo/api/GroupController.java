package com.example.demo.api;

import com.example.demo.domain.Groups;
import com.example.demo.domain.Trainee;
import com.example.demo.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO GTB：缺少修改组名的接口
@RestController
@RequestMapping("/groups")
@CrossOrigin("http://localhost:1234")
public class GroupController {
    private final GroupService groupService;
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    //TODO GTB: 如果path为空，可以不写""
    @GetMapping("")
    public List<Groups> getAllGroups(){
        return groupService.getAllGroups();
    }

    //TODO GTB：BUG，再次调用自动分组的时候会有问题
    @PostMapping("/auto-grouping")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Groups> autoGrouping(){
        return groupService.autoGrouping();
    }
}
