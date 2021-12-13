package com.monda.epatient.kahiya.controller;

import com.monda.epatient.kahiya.dto.res.ResponseWrapper;
import com.monda.epatient.kahiya.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class AppInfoController {
    @GetMapping(value = "/app-info")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseWrapper<String> findAllDoctors() throws NotFoundException {
        return new ResponseWrapper<>(true, null, "ePatient Server");
    }
}
