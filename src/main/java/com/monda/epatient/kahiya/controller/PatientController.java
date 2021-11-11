package com.monda.epatient.kahiya.controller;

import com.monda.epatient.kahiya.dto.res.AppointmentRes;
import com.monda.epatient.kahiya.dto.res.ResponseWrapper;
import com.monda.epatient.kahiya.dto.res.UpdateAppointmentStatusReq;
import com.monda.epatient.kahiya.exception.NotFoundException;
import com.monda.epatient.kahiya.exception.WrongParameterException;
import com.monda.epatient.kahiya.service.AppointmentService;
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
}
