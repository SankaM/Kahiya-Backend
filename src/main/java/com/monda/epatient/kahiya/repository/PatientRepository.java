package com.monda.epatient.kahiya.repository;

import com.monda.epatient.kahiya.model.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, UUID> {
    Optional<PatientEntity> findByUserName(String userName);

    Optional<PatientEntity> findByEmail(String email);
}
