package com.example.demo.repository;

import com.example.demo.domain.Groups;
import com.example.demo.domain.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupsRepository extends JpaRepository<Groups, Long> {
}
