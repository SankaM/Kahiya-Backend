package com.monda.epatient.wahiya.repository;

import com.monda.epatient.wahiya.model.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DoctorEntityRepository extends JpaRepository<DoctorEntity, UUID> {

    Optional<DoctorEntity> findByUserName(String userName);


}
