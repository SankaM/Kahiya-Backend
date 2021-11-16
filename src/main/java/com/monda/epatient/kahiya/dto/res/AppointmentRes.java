package com.monda.epatient.kahiya.dto.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.monda.epatient.kahiya.model.AppointmentEntity;
import com.monda.epatient.kahiya.model.PaymentEntity;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppointmentRes {
    private UUID id;

    private DoctorRes doctor;

    private WorkHourRes workHour;

    private PaymentRes payment;

    private String appointmentDate;

    private String updatedDate;

    private AppointmentEntity.AppointmentStatus status;

    public static AppointmentRes build(AppointmentEntity appointment) {
        AppointmentRes res = null;

        if(appointment != null) {
            res = new AppointmentRes();
            res.id = appointment.getId();
            res.doctor = DoctorRes.buildSimple(appointment.getDoctor());
            res.workHour = WorkHourRes.build(appointment.getWorkHour());
            res.appointmentDate = appointment.getAppointmentDate() != null ? appointment.getAppointmentDate().toString() : null;
            res.updatedDate = appointment.getUpdatedDate() != null ? appointment.getUpdatedDate().toString() : null;
            res.status = appointment.getStatus();
        }

        return res;
    }

    public static AppointmentRes build(AppointmentEntity appointment, PaymentEntity payment) {
        AppointmentRes res = null;

        if(appointment != null) {
            res = new AppointmentRes();
            res.id = appointment.getId();
            res.doctor = DoctorRes.buildSimple(appointment.getDoctor());
            res.workHour = WorkHourRes.build(appointment.getWorkHour());
            res.appointmentDate = appointment.getAppointmentDate() != null ? appointment.getAppointmentDate().toString() : null;
            res.status = appointment.getStatus();
            res.payment = PaymentRes.buildSimple(payment);
        }

        return res;
    }
}
