package com.monda.epatient.kahiya.controller;

import com.monda.epatient.kahiya.dto.req.MakeAppointmentReq;
import com.monda.epatient.kahiya.dto.res.AppointmentRes;
import com.monda.epatient.kahiya.dto.res.ResponseWrapper;
import com.monda.epatient.kahiya.dto.res.UpdateAppointmentStatusReq;
import com.monda.epatient.kahiya.exception.LoginException;
import com.monda.epatient.kahiya.exception.NotFoundException;
import com.monda.epatient.kahiya.exception.WrongParameterException;
import com.monda.epatient.kahiya.service.AppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping(value = "/appointment")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseWrapper<AppointmentRes> makeAppointment(@RequestBody MakeAppointmentReq req) throws LoginException {
        return new ResponseWrapper<>(true, null, appointmentService.makeAppointment(req));
    }
}
