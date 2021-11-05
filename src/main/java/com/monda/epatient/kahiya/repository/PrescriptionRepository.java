package com.monda.epatient.kahiya.repository;

import com.monda.epatient.kahiya.model.PrescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PrescriptionRepository extends JpaRepository<PrescriptionEntity, UUID> {
    @Query("SELECT count(p.diagnosis) FROM PrescriptionEntity p WHERE p.doctor.id = :doctorId")
    int countDiagnosticByDoctorId(UUID doctorId);

    @Query("SELECT count(p) FROM PrescriptionEntity p WHERE p.doctor.id = :doctorId AND size(p.dosageList) > 0")
    int countPrescriptionWithDosageByDoctorId(UUID doctorId);
}
