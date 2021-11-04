package com.monda.epatient.kahiya.service;

import com.monda.epatient.kahiya.dto.res.DoctorRes;
import com.monda.epatient.kahiya.model.DoctorEntity;
import com.monda.epatient.kahiya.repository.DoctorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DoctorService {
    public static enum SearchDoctorField {
        NAME, MOBILE_PHONE
    }

    @Autowired
    private DoctorRepository doctorRepository;

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
}
