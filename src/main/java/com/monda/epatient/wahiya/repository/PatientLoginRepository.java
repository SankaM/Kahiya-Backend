package com.monda.epatient.wahiya.repository;

import com.monda.epatient.wahiya.model.PatientLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientLoginRepository extends JpaRepository<PatientLoginEntity, Long> {
    PatientLoginEntity findByUserName(String userName);
}
