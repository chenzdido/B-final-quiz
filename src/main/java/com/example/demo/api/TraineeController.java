package com.example.demo.api;

import com.example.demo.domain.Trainee;
import com.example.demo.service.TraineeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/trainees")
@CrossOrigin("http://localhost:1234")
public class TraineeController {
    private final TraineeService traineeService;
    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @GetMapping("")
    public List<Trainee> getAllTrainee(@RequestParam(value = "grouped", required = false) String grouped){
        return traineeService.getTrainee(grouped);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Trainee addTrainee(@RequestBody @Valid Trainee trainee){
        return traineeService.addTrainee(trainee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrainee(@PathVariable Long id){
        traineeService.deleteTrainee(id);
    }




}
