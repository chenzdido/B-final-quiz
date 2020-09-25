package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank(message = "trainee name is not empty")
    String name;
    @NotBlank(message = "office is not empty")
    String office;
    @NotBlank(message = "email is not empty")
    @Email
    String email;
    @NotBlank(message = "github is not empty")
    String github;
    @NotBlank(message = "zoomId is not empty")
    String zoomId;
    //TODO GTB: grouped看起来就两个状态，true/false，考虑下boolean？
    @JsonIgnore
    String grouped;
    @ManyToOne
    @JsonIgnore
    Groups groups;

}
