package com.monda.edoctor.wahiya.repository;

import com.monda.edoctor.wahiya.model.PatientSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientSessionRepository  extends JpaRepository<PatientSessionEntity, Long> {
    PatientSessionEntity getPatientSessionEntityByTokenAndPatientLoginUserName(String token, String username);
}
