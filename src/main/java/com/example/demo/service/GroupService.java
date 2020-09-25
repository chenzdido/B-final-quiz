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

    public List<Groups> getAllGroups(){
        return groupsRepository.findAll();
    }

    public List<Groups> autoGrouping(){
        //TODO GTB：这个方法太长了，需要分模块抽方法重构
        List<Trainer> trainerList = trainerRepository.findAll();
        //TODO GTB：Magic Number 2
        int groupNumber = trainerList.size()/2;
        List<Trainee> traineesList = traineeRepository.findAll();
        List<List<Trainee>> traineesGroup = new ArrayList<>(groupNumber);
        for (int key = 0; key <groupNumber; key++){
            traineesGroup.add(new ArrayList<Trainee>());
        }
        Collections.shuffle(trainerList);
        //TODO GTB: 尽量避免控制台输出log，可以看看@Slf4j，以及log输出规范
        System.out.println(traineesGroup.size());
        System.out.println(trainerList);
        Collections.shuffle(traineesList);
        System.out.println(traineesList);
        //TODO GTB：变量名需要合理一些
        for (int i = 0; i < traineesList.size();){
            for (int k = 0; i < traineesList.size() && k <groupNumber; k++, i++){
                traineesGroup.get(k).add(traineesList.get(i));
            }
        }
        System.out.println(traineesGroup);
        for(int j =0; j< groupNumber; j++){
            String groupName = j+1+"组";
            Groups groups = Groups.builder()
                    .name(groupName)
                    .trainees(traineesGroup.get(j))
                    .trainers(trainerList.subList(j*2,(j+1)*2))
                    .build();
            System.out.println(groups);
            groupsRepository.save(groups);

        }
        return groupsRepository.findAll();
    }


}
