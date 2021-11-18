package com.monda.epatient.kahiya.controller;

import com.monda.epatient.kahiya.dto.req.UpdateTakenMedicineReq;
import com.monda.epatient.kahiya.dto.res.ResponseWrapper;
import com.monda.epatient.kahiya.dto.res.TakenMedicineRes;
import com.monda.epatient.kahiya.service.PrescriptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1")
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping(value = "/prescription/taken-medicine/{patientId}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseWrapper<List<TakenMedicineRes>> findAllTakenMedicineByPatientId(@PathVariable("patientId") UUID patientId) {
        return new ResponseWrapper<List<TakenMedicineRes>>(true, null, prescriptionService.findAllTakenMedicine(patientId));
    }

    @PostMapping(value = "/prescription/taken-medicine")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseWrapper updateTakenMedicine(@RequestBody UpdateTakenMedicineReq req) {
        prescriptionService.updateTakenMedicineStatus(req);
        return new ResponseWrapper(true, null, null);
    }
}
