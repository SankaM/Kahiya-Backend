//package com.monda.epatient.wahiya._old.repository;
//
//import com.monda.epatient.wahiya._old.model.PatientEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//import java.util.UUID;
//
///**
// * Spring Data JPA interface to query tutorial data
// *
// * @author Priyantha Weerakoon
// */
//public interface PatientEntityRepository extends JpaRepository<PatientEntity, UUID> {
//
//    void deleteByPatientId(UUID patientId);
//
//    List<PatientEntity> findByDoctorIdAndIsActive(String doctorId, Boolean isActive);
//
//    PatientEntity findByDoctorIdAndPatientId(String doctorId, UUID patientId);
//}