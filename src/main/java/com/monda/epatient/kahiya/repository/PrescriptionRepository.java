package com.monda.epatient.kahiya.repository;

import com.monda.epatient.kahiya.model.PrescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface PrescriptionRepository extends JpaRepository<PrescriptionEntity, UUID> {
    @Query("SELECT count(p.diagnosis) FROM PrescriptionEntity p WHERE p.doctor.id = :doctorId")
    int countDiagnosticByDoctorId(UUID doctorId);

    @Query("SELECT count(p) FROM PrescriptionEntity p WHERE p.doctor.id = :doctorId AND size(p.dosageList) > 0")
    int countPrescriptionWithDosageByDoctorId(UUID doctorId);

    @Query("select p from PrescriptionEntity p where p.patient.id = :patientId and p.lastTreatmentDate < :currentDate ")
    List<PrescriptionEntity> findExpiredPrescription(UUID patientId, LocalDateTime currentDate);

    @Query("select p from PrescriptionEntity p where p.patient.id = :patientId and p.lastTreatmentDate >= :currentDate ")
    List<PrescriptionEntity> findNotExpiredPrescription(UUID patientId, LocalDateTime currentDate);
}
