package com.monda.epatient.kahiya.service;

import com.monda.epatient.kahiya.dto.req.MakeAppointmentReq;
import com.monda.epatient.kahiya.dto.res.AppointmentRes;
import com.monda.epatient.kahiya.model.AppointmentEntity;
import com.monda.epatient.kahiya.repository.AppointmentRepository;
import com.monda.epatient.kahiya.repository.DoctorRepository;
import com.monda.epatient.kahiya.repository.PatientRepository;
import com.monda.epatient.kahiya.repository.WorkHourRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private WorkHourRepository workHourRepository;

    public AppointmentRes makeAppointment(MakeAppointmentReq req) {
        AppointmentEntity appointment = AppointmentEntity.builder()
                .doctor(doctorRepository.getOne(req.getDoctorId()))
                .patient(patientRepository.getOne(req.getPatientId()))
                .workHour(workHourRepository.getOne(req.getWorkHourId()))
                .appointmentDate(LocalDate.parse(req.getAppointmentDate()))
                .build();

        appointment = appointmentRepository.save(appointment);

        return AppointmentRes.build(appointment);
    }
}
