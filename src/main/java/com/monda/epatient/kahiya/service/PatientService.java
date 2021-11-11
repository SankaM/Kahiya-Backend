package com.monda.epatient.kahiya.service;

import com.monda.epatient.kahiya.exception.NotFoundException;
import com.monda.epatient.kahiya.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public boolean existsById(UUID id) throws NotFoundException {
        if (!patientRepository.existsById(id)) {
            log.error("Patient ID not available : {}", id);
            throw new NotFoundException("Patient ID not available");
        }

        return true;
    }
}
