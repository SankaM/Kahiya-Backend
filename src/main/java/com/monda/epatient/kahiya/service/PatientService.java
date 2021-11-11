package com.monda.epatient.kahiya.service;

import com.monda.epatient.kahiya.dto.res.PatientRes;
import com.monda.epatient.kahiya.dto.res.PrescriptionRes;
import com.monda.epatient.kahiya.exception.NotFoundException;
import com.monda.epatient.kahiya.model.DiagnosisEntity;
import com.monda.epatient.kahiya.model.PatientEntity;
import com.monda.epatient.kahiya.model.PrescriptionEntity;
import com.monda.epatient.kahiya.repository.PatientRepository;
import com.monda.epatient.kahiya.repository.PrescriptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public boolean existsById(UUID id) throws NotFoundException {
        if (!patientRepository.existsById(id)) {
            log.error("Patient ID not available : {}", id);
            throw new NotFoundException("Patient ID not available");
        }

        return true;
    }

    public PatientRes getPatientDetails(UUID patientId) throws NotFoundException {
        existsById(patientId);

        PatientEntity patientEntity = patientRepository.getOne(patientId);
        return PatientRes.buildDetail(patientEntity, findLastPatientDiagnosis(patientId));
    }

    protected DiagnosisEntity findLastPatientDiagnosis(UUID patientId) {
        LocalDateTime now = LocalDate.now().atStartOfDay();
        List<PrescriptionEntity> prescriptions = prescriptionRepository.findNotExpiredPrescription(patientId, now);

        if(prescriptions != null && prescriptions.size() > 0) {
            return prescriptions.get(0).getDiagnosis();
        }

        return null;
    }

    public List<PrescriptionRes> retrievePastPrescriptions(UUID patientId) throws NotFoundException {
        existsById(patientId);

        LocalDateTime now = LocalDate.now().atStartOfDay();
        List<PrescriptionEntity> prescriptionEntityList = prescriptionRepository.findExpiredPrescription(patientId, now);

        return prescriptionEntityList
                .stream()
                .map(prescription -> PrescriptionRes.buildDetail(prescription))
                .collect(Collectors.toList());
    }

    public List<PrescriptionRes> retrieveCurrentPrescriptions(UUID patientId) throws NotFoundException {
        existsById(patientId);

        LocalDateTime now = LocalDate.now().atStartOfDay();
        List<PrescriptionEntity> prescriptionEntityList = prescriptionRepository.findNotExpiredPrescription(patientId, now);

        return prescriptionEntityList
                .stream()
                .map(prescription -> PrescriptionRes.buildDetail(prescription))
                .collect(Collectors.toList());
    }
}
