package com.example.demo.service;

import com.example.demo.domain.Groups;
import com.example.demo.domain.Trainee;
import com.example.demo.domain.Trainer;
import com.example.demo.repository.GroupsRepository;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GroupService {
    private final TraineeRepository traineeRepository;
    private final TrainerRepository trainerRepository;
    private final GroupsRepository groupsRepository;
    public GroupService(TraineeRepository traineeRepository, TrainerRepository trainerRepository, GroupsRepository groupsRepository) {
        this.traineeRepository = traineeRepository;
        this.trainerRepository = trainerRepository;
        this.groupsRepository = groupsRepository;
    }

    public List<Groups> autoGrouping(){
        List<Trainer> trainerList = trainerRepository.findAll();
        int groupNumber = trainerList.size()/2;
        List<Trainee> traineesList = traineeRepository.findAll();
        List<List<Trainee>> traineesGroup = new ArrayList<>(groupNumber);
        for (int key = 0; key <groupNumber; key++){
            traineesGroup.add(new ArrayList<Trainee>());
        }
        Collections.shuffle(trainerList);
        System.out.println(traineesGroup.size());
        System.out.println(trainerList);
        Collections.shuffle(traineesList);
        System.out.println(traineesList);
        for (int i = 0; i < traineesList.size();){
            for (int k = 0; i < traineesList.size() && k <groupNumber; k++, i++){
                traineesGroup.get(k).add(traineesList.get(i));
            }
        }
        System.out.println(traineesGroup);
        for(int j =0; j< groupNumber; j++){
            String groupName = j+"组";
            Groups groups = Groups.builder()
                    .name(groupName)
                    .trainees(traineesGroup.get(j))
                    .trainers(trainerList.subList(j,j*2))
                    .build();
            System.out.println(groups);
            groupsRepository.save(groups);

        }
        return groupsRepository.findAll();
    }
}
