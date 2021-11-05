package com.monda.epatient.kahiya.service;

import com.monda.epatient.kahiya.dto.res.DoctorRes;
import com.monda.epatient.kahiya.dto.res.DoctorStatisticRes;
import com.monda.epatient.kahiya.dto.res.WorkHourRes;
import com.monda.epatient.kahiya.exception.NotFoundException;
import com.monda.epatient.kahiya.model.DoctorEntity;
import com.monda.epatient.kahiya.repository.DoctorRepository;
import com.monda.epatient.kahiya.repository.PrescriptionRepository;
import com.monda.epatient.kahiya.repository.WorkHourRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DoctorService {
    public static enum SearchDoctorField {
        NAME, MOBILE_PHONE
    }

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private WorkHourRepository workHourRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public boolean existsById(UUID id) throws NotFoundException {
        if (!doctorRepository.existsById(id)) {
            log.error("Doctor ID not available : {}", id);
            throw new NotFoundException("Doctor ID not available");
        }

        return true;
    }

    public List<DoctorRes> findAll() {
        List<DoctorEntity> doctors = doctorRepository.findAll();

        if (!doctors.isEmpty()) {
            return doctors.stream().map(d -> DoctorRes.buildSimple(d)).collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    public List<DoctorRes> searchDoctors(String query, SearchDoctorField field) {
        List<DoctorEntity> doctors = new ArrayList<>();

        switch (field) {
            case NAME: {
                doctors = doctorRepository.findByName(query);
                break;
            }
            case MOBILE_PHONE: {
                doctors = doctorRepository.findByMobilePhoneContains(query);
                break;
            }
        }

        if (!doctors.isEmpty()) {
            return doctors.stream().map(d -> DoctorRes.buildSimple(d)).collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    public DoctorRes getProfile(UUID doctorId) throws NotFoundException {
        existsById(doctorId);
        return DoctorRes.buildDetail(doctorRepository.getOne(doctorId));
    }

    public List<WorkHourRes> getWorkHours(UUID doctorId) throws NotFoundException {
        existsById(doctorId);

        return workHourRepository.findByDoctorId(doctorId)
                .stream()
                .map(workHour -> WorkHourRes.build(workHour))
                .collect(Collectors.toList());
    }

    public DoctorStatisticRes getStatisticsRes(UUID doctorId) throws NotFoundException {
        existsById(doctorId);

        int totalDiagnostic = prescriptionRepository.countDiagnosticByDoctorId(doctorId);
        int totalPrescription = prescriptionRepository.countPrescriptionWithDosageByDoctorId(doctorId);

        return DoctorStatisticRes.buildSimple(totalDiagnostic, totalPrescription);
    }
}
