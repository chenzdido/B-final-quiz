package com.example.demo.service;

import com.example.demo.domain.Trainee;
import com.example.demo.repository.TraineeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraineeService {
    private final TraineeRepository traineeRepository;
    public TraineeService(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
        traineeRepository.save(Trainee.builder()
                .name("谌哲")
                .office("深圳")
                .email("zhe.chen@thousghtworks.com")
                .githubName("chenZ")
                .zoomId("chenZ")
                .grouped("false")
                .build());
        traineeRepository.save(Trainee.builder()
                .name("Foo")
                .office("西安")
                .email("foo@thousghtworks.com")
                .githubName("foo")
                .zoomId("foo")
                .grouped("false")
                .build());
        traineeRepository.save(Trainee.builder()
                .name("Bar")
                .office("深圳")
                .email("Bar@thousghtworks.com")
                .githubName("Bar")
                .zoomId("Bar")
                .grouped("false")
                .build());
    }

    public List<Trainee> getTrainee(String grouped){
        return traineeRepository.findAllByGrouped(grouped);
    }
}