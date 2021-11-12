package com.monda.epatient.kahiya.service;

import com.monda.epatient.kahiya.dto.req.MakeAppointmentReq;
import com.monda.epatient.kahiya.dto.res.AppointmentRes;
import com.monda.epatient.kahiya.dto.res.UpdateAppointmentStatusReq;
import com.monda.epatient.kahiya.exception.NotFoundException;
import com.monda.epatient.kahiya.exception.WrongParameterException;
import com.monda.epatient.kahiya.model.AppointmentEntity;
import com.monda.epatient.kahiya.repository.AppointmentRepository;
import com.monda.epatient.kahiya.repository.DoctorRepository;
import com.monda.epatient.kahiya.repository.PatientRepository;
import com.monda.epatient.kahiya.repository.WorkHourRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @Autowired
    private PatientService patientService;

    public AppointmentRes makeAppointment(MakeAppointmentReq req) {
        AppointmentEntity appointment = AppointmentEntity.builder()
                .doctor(doctorRepository.getOne(req.getDoctorId()))
                .patient(patientRepository.getOne(req.getPatientId()))
                .workHour(workHourRepository.getOne(req.getWorkHourId()))
                .appointmentDate(LocalDateTime.parse(req.getAppointmentDate()))
                .status(AppointmentEntity.AppointmentStatus.REQUESTED)
                .build();

        appointment = appointmentRepository.save(appointment);

        return AppointmentRes.build(appointment);
    }

    public List<AppointmentRes> retrievePastAppointment(UUID patientId) throws NotFoundException {
        patientService.existsById(patientId);

        LocalDateTime now = LocalDate.now().atStartOfDay();

        return appointmentRepository.findBeforeDate(patientId, now)
                .stream()
                .map(appointment -> AppointmentRes.build(appointment))
                .collect(Collectors.toList());
    }

    public List<AppointmentRes> retrieveFutureAppointment(UUID patientId) throws NotFoundException {
        patientService.existsById(patientId);

        LocalDateTime now = LocalDate.now().atStartOfDay();

        return appointmentRepository.findAfterDate(patientId, now)
                .stream()
                .map(appointment -> AppointmentRes.build(appointment))
                .collect(Collectors.toList());
    }

    public AppointmentRes updateAppointmentStatus(UUID patientId, UUID appointmentId, UpdateAppointmentStatusReq req) throws NotFoundException, WrongParameterException {
        patientService.existsById(patientId);
        Optional<AppointmentEntity> appointmentOpt = appointmentRepository.findByPatientIdAndAppointmentId(patientId, appointmentId);

        if(!appointmentOpt.isPresent()) {
            throw new NotFoundException("No Appointment for specified doctor");
        }

        AppointmentEntity appointment = appointmentOpt.get();
        appointment.setStatus(req.getAppointmentStatus());
        AppointmentEntity updatedAppointment = appointmentRepository.save(appointment);

        return AppointmentRes.build(updatedAppointment);
    }
}
