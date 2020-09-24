package com.example.demo.service;

import com.example.demo.domain.Trainee;
import com.example.demo.domain.Trainer;
import com.example.demo.exception.IDNotFoundException;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Trainer addTrainer(Trainer trainer){
        trainer.setGrouped("false");
        return trainerRepository.save(trainer);
    }

    public void deleteTrainer(Long id) {
        if(trainerRepository.findById(id).equals(Optional.empty()))
        {
            throw new IDNotFoundException("trainer id is not exist");
        }
        trainerRepository.deleteById(id);
    }
}
