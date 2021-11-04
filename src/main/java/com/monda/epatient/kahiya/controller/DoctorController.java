package com.monda.epatient.kahiya.controller;

import com.monda.epatient.kahiya.dto.res.DoctorRes;
import com.monda.epatient.kahiya.dto.res.ResponseWrapper;
import com.monda.epatient.kahiya.exception.NotFoundException;
import com.monda.epatient.kahiya.exception.WrongParameterException;
import com.monda.epatient.kahiya.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping(value = "/doctors")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseWrapper<List<DoctorRes>> findAllDoctors() throws NotFoundException {
        return new ResponseWrapper<>(true, null, doctorService.findAll());
    }

    @GetMapping(value = "/doctors/search")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseWrapper<List<DoctorRes>> searchDoctors(@RequestParam("query") String query,
                                                          @RequestParam("field") String fieldAsString) throws WrongParameterException {

        DoctorService.SearchDoctorField field;
        try {
            field = DoctorService.SearchDoctorField.valueOf(fieldAsString);
        } catch (Exception e) {
            throw new WrongParameterException("Wrong field value");
        }

        return new ResponseWrapper<>(true, null, doctorService.searchDoctors(query, field));
    }
}
