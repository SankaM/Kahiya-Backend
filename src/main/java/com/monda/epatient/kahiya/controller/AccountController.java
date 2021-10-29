package com.monda.epatient.kahiya.controller;

import com.monda.epatient.kahiya.dto.req.LoginReq;
import com.monda.epatient.kahiya.dto.req.SignUpReq;
import com.monda.epatient.kahiya.dto.res.LoginRes;
import com.monda.epatient.kahiya.dto.res.ResponseWrapper;
import com.monda.epatient.kahiya.exception.DuplicateContentException;
import com.monda.epatient.kahiya.exception.LoginException;
import com.monda.epatient.kahiya.model.PatientEntity;
import com.monda.epatient.kahiya.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/patient/login")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseWrapper<LoginRes> login(@RequestBody LoginReq loginReq) throws LoginException {
        PatientEntity doctorEntity = accountService.validatePatientLogin(loginReq);
        return new ResponseWrapper<>(true, null, LoginRes.buildDetail(doctorEntity));
    }

    @PostMapping(value = "/patient/signup")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseWrapper<LoginRes> login(@RequestBody SignUpReq req) throws DuplicateContentException {
        PatientEntity patientEntity = accountService.signUp(req);
        return new ResponseWrapper<>(true, null, LoginRes.buildDetail(patientEntity));
    }
}
