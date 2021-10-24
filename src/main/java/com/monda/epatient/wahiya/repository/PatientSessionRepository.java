package com.monda.epatient.wahiya.repository;

import com.monda.epatient.wahiya.model.PatientSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientSessionRepository  extends JpaRepository<PatientSessionEntity, Long> {
    PatientSessionEntity getPatientSessionEntityByTokenAndPatientLoginUserName(String token, String username);
}
