package com.monda.epatient.kahiya.dto.req;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MakeAppointmentReq {
    private UUID patientId;

    private UUID doctorId;
    
    private UUID workHourId;

    private String appointmentDate;
}
