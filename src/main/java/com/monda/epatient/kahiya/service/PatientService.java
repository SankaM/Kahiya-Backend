package com.monda.epatient.kahiya.service;

import com.monda.epatient.kahiya.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;


}
