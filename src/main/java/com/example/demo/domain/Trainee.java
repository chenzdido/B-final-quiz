package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NotBlank(message = "user name is not empty")
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
    @JsonIgnore
    String grouped;

}
