package com.monda.epatient.kahiya.repository;

import com.monda.epatient.kahiya.model.TakenMedicineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TakenMedicineRepository extends JpaRepository<TakenMedicineEntity, UUID> {
    @Query("SELECT t FROM TakenMedicineEntity t WHERE t.dosage.prescription.patient.id = :patientId order by t.scheduledTakenDate desc")
    List<TakenMedicineEntity> findByPatientId(UUID patientId);
}
