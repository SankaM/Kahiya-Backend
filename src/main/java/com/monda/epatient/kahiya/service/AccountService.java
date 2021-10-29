package com.monda.epatient.kahiya.service;

import com.monda.epatient.kahiya.dto.req.LoginReq;
import com.monda.epatient.kahiya.exception.LoginException;
import com.monda.epatient.kahiya.model.PatientEntity;
import com.monda.epatient.kahiya.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public PatientEntity validatePatientLogin(LoginReq loginReq) throws LoginException {
        PatientEntity patientEntity = patientRepository.findByUserName(loginReq.getUserName()).orElseThrow(LoginException::new);
        if (passwordEncoder.matches(loginReq.getPassword(), patientEntity.getPassword())) {
            return patientEntity;
        }

        log.debug("Password does not matched :" + patientEntity.getUserName());
        throw new LoginException();
    }
}
