package com.monda.epatient.kahiya.controller;

import com.monda.epatient.kahiya.dto.res.*;
import com.monda.epatient.kahiya.exception.NotFoundException;
import com.monda.epatient.kahiya.exception.WrongParameterException;
import com.monda.epatient.kahiya.service.AppointmentService;
import com.monda.epatient.kahiya.service.PatientService;
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
public class PatientController {
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;

    @GetMapping(value = "/patient/{patientId}/appointment/past")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseWrapper<List<AppointmentRes>> getPastAppointment(@PathVariable("patientId") UUID patientId) throws NotFoundException {
        return new ResponseWrapper<>(true, null, appointmentService.retrievePastAppointment(patientId));
    }

    @GetMapping(value = "/patient/{patientId}/appointment/upcoming")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseWrapper<List<AppointmentRes>> getFutureAppointment(@PathVariable("patientId") UUID patientId) throws NotFoundException {
        return new ResponseWrapper<>(true, null, appointmentService.retrieveFutureAppointment(patientId));
    }

    @PutMapping(value = "/patient/{patientId}/appointment/{appointmentId}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseWrapper<AppointmentRes> updateAppointment(@PathVariable("patientId") UUID patientId,
                                             @PathVariable("appointmentId") UUID appointmentId,
                                             @RequestBody UpdateAppointmentStatusReq req) throws NotFoundException, WrongParameterException {
        return new ResponseWrapper<>(true, null, appointmentService.updateAppointmentStatus(patientId, appointmentId, req));
    }

    @GetMapping(value = "/patient/{patientId}/prescription/current")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseWrapper<List<PrescriptionRes>> getCurrentPrescription(@PathVariable("patientId") UUID patientId) throws NotFoundException {
        return new ResponseWrapper<>(true, null, patientService.retrieveCurrentPrescriptions(patientId));
    }

    @GetMapping(value = "/patient/{patientId}/prescription/past")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseWrapper<List<PrescriptionRes>> getLastPrescription(@PathVariable("patientId") UUID patientId) throws NotFoundException {
        return new ResponseWrapper<>(true, null, patientService.retrievePastPrescriptions(patientId));
    }

    @GetMapping(value = "/patient/{patientId}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseWrapper<PatientRes> getPatientDetails(@PathVariable("patientId") UUID patientId) throws NotFoundException {
        return new ResponseWrapper<>(true, null, patientService.getPatientDetails(patientId));
    }
}
