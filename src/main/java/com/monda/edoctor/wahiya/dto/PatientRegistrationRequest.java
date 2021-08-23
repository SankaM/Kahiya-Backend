package com.monda.edoctor.wahiya.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientRegistrationRequest {
    private String email;
    private String password;
    private String name;
    private Integer age;
    private LocalDate birthDate;
    private String mobile;
    private String healthProfile;
    private String imageUrl;
}
