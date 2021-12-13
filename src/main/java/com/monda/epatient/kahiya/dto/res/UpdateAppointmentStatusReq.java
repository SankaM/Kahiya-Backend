package com.monda.epatient.kahiya.dto.res;

import com.monda.epatient.kahiya.exception.WrongParameterException;
import com.monda.epatient.kahiya.model.AppointmentEntity;
import lombok.Data;

@Data
public class UpdateAppointmentStatusReq {
    private String status;

    public AppointmentEntity.AppointmentStatus getAppointmentStatus() throws WrongParameterException {
        if(status != null) {
            try {
                return AppointmentEntity.AppointmentStatus.valueOf(status);
            } catch (Exception e) {
                throw new WrongParameterException("Wrong field value");
            }
        }

        return null;
    }
}
