package com.example.demo.api;

import com.example.demo.domain.Trainee;
import com.example.demo.service.TraineeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trainees")
public class TraineeController {
    private final TraineeService traineeService;
    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @GetMapping("")
    public List<Trainee> getAllStudents(@RequestParam(value = "grouped", required = false) String grouped){
        return traineeService.getTrainee(grouped);
    }




}
