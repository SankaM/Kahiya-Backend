package com.monda.epatient.kahiya.service;

import com.monda.epatient.kahiya.dto.req.UpdateTakenMedicineReq;
import com.monda.epatient.kahiya.dto.res.TakenMedicineRes;
import com.monda.epatient.kahiya.model.TakenMedicineEntity;
import com.monda.epatient.kahiya.repository.TakenMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PrescriptionService {
    @Autowired
    private TakenMedicineRepository takenMedicineRepository;

    void markAsTaken(UUID takenMedicineId) {
        TakenMedicineEntity takenMedicine = takenMedicineRepository.getOne(takenMedicineId);
        takenMedicine.setTakenStatus(TakenMedicineEntity.TakenStatus.TAKEN);
        takenMedicine.setTakenStatusDate(LocalDateTime.now());

        takenMedicineRepository.save(takenMedicine);
    }

    void markAsNotTaken(UUID takenMedicineId) {
        TakenMedicineEntity takenMedicine = takenMedicineRepository.getOne(takenMedicineId);
        takenMedicine.setTakenStatus(TakenMedicineEntity.TakenStatus.NOT_TAKEN);
        takenMedicine.setTakenStatusDate(LocalDateTime.now());

        takenMedicineRepository.save(takenMedicine);
    }

    public List<TakenMedicineRes> findAllTakenMedicine(UUID patientId) {
        return takenMedicineRepository.findByPatientId(patientId)
                .stream()
                .map(takenMedicine -> TakenMedicineRes.build(takenMedicine))
                .collect(Collectors.toList());
    }

    public void updateTakenMedicineStatus(UpdateTakenMedicineReq req) {
        TakenMedicineEntity takenMedicine = takenMedicineRepository.getOne(req.getTakenMedicineId());
        if(req.getTaken()) {
            takenMedicine.setTakenStatus(TakenMedicineEntity.TakenStatus.TAKEN);
        } else {
            takenMedicine.setTakenStatus(TakenMedicineEntity.TakenStatus.NOT_TAKEN);
        }

        takenMedicine.setTakenStatusDate(LocalDateTime.now());

        takenMedicineRepository.save(takenMedicine);
    }
}
