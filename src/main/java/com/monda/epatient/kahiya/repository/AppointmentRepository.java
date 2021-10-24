package com.monda.epatient.kahiya.repository;

import com.monda.epatient.kahiya.model.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, UUID> {
}
