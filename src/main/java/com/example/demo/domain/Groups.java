package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank(message = "trainee name is not empty")
    String name;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<Trainee> trainees;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<Trainer> trainers;
    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
    }
    public void addTrainer(Trainee trainer) {
        trainees.add(trainer);
    }
}
