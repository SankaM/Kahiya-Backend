package com.monda.epatient.kahiya.controller;

import com.monda.epatient.kahiya.dto.res.DoctorRes;
import com.monda.epatient.kahiya.dto.res.DoctorStatisticRes;
import com.monda.epatient.kahiya.dto.res.ResponseWrapper;
import com.monda.epatient.kahiya.dto.res.WorkHourRes;
import com.monda.epatient.kahiya.exception.NotFoundException;
import com.monda.epatient.kahiya.exception.WrongParameterException;
import com.monda.epatient.kahiya.service.DoctorService;
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

    @GetMapping(value = "/doctors/{doctorId}/profile")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseWrapper<DoctorRes> getProfile(@PathVariable("doctorId") UUID doctorId) throws NotFoundException {
        return new ResponseWrapper(true, null, doctorService.getProfile(doctorId));
    }

    @GetMapping(value = "/doctors/{doctorId}/work-hours")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseWrapper<List<WorkHourRes>> getWorkHours(@PathVariable("doctorId") UUID doctorId) throws NotFoundException {
        return new ResponseWrapper(true, null, doctorService.getWorkHours(doctorId));
    }

    @GetMapping(value = "/doctors/{doctorId}/statistics")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseWrapper<DoctorStatisticRes> getStatistics(@PathVariable("doctorId") UUID doctorId) throws NotFoundException {
        return new ResponseWrapper(true, null, doctorService.getStatisticsRes(doctorId));
    }
}
