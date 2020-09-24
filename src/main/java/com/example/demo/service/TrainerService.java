package com.example.demo.service;

import com.example.demo.domain.Trainer;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {
    private final TrainerRepository trainerRepository;
    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
        trainerRepository.save(Trainer.builder()
                .name("Fizz")
                .grouped("false")
                .build());
        trainerRepository.save(Trainer.builder()
                .name("Buzz")
                .grouped("false")
                .build());

    }

    public List<Trainer> getTrainer(String grouped){
        return trainerRepository.findAllByGrouped(grouped);
    }
}
