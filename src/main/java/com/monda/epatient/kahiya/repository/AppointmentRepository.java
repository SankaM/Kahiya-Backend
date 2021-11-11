package com.monda.epatient.kahiya.repository;

import com.monda.epatient.kahiya.model.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, UUID> {
    @Query("select a from AppointmentEntity a where a.patient.id = :patientId and a.appointmentDate < :beforeDate order by a.appointmentDate desc")
    List<AppointmentEntity> findBeforeDate(UUID patientId, LocalDateTime beforeDate);

    @Query("select a from AppointmentEntity a where a.patient.id = :patientId and a.appointmentDate >= :afterDate")
    List<AppointmentEntity> findAfterDate(UUID patientId, LocalDateTime afterDate);

    @Query("select a from AppointmentEntity a where a.patient.id = :patientId and a.id = :appointmentId")
    Optional<AppointmentEntity> findByPatientIdAndAppointmentId(UUID patientId, UUID appointmentId);
}
