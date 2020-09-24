package com.example.demo.service;

import com.example.demo.domain.Trainee;
import com.example.demo.exception.IDNotFoundException;
import com.example.demo.repository.TraineeRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class TraineeService {
    private final TraineeRepository traineeRepository;
    public TraineeService(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
        traineeRepository.save(Trainee.builder()
                .name("谌哲")
                .office("深圳")
                .email("zhe.chen@thousghtworks.com")
                .github("chenZ")
                .zoomId("chenZ")
                .grouped("false")
                .build());
        traineeRepository.save(Trainee.builder()
                .name("Foo")
                .office("西安")
                .email("foo@thousghtworks.com")
                .github("foo")
                .zoomId("foo")
                .grouped("false")
                .build());
        traineeRepository.save(Trainee.builder()
                .name("Bar")
                .office("深圳")
                .email("Bar@thousghtworks.com")
                .github("Bar")
                .zoomId("Bar")
                .grouped("false")
                .build());
    }

    public List<Trainee> getTrainee(String grouped){
        return traineeRepository.findAllByGrouped(grouped);
    }

    public Trainee addTrainee(Trainee trainee){
        trainee.setGrouped("false");
        return traineeRepository.save(trainee);
    }

    public void deleteTrainee(Long id) {
        if(traineeRepository.findById(id).equals(Optional.empty()))
        {
            throw new IDNotFoundException("trainee is not exist");
        }
        traineeRepository.deleteById(id);
    }
}
