package com.monda.edoctor.wahiya.repository;

import com.monda.edoctor.wahiya.model.PatientLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientLoginRepository extends JpaRepository<PatientLoginEntity, Long> {
    PatientLoginEntity findByUserName(String userName);
}
