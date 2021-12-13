package com.monda.epatient.kahiya.dto.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoctorStatisticRes {
    private int totalDiagnostics;

    private int totalPrescriptions;

    public static DoctorStatisticRes buildSimple(int totalDiagnostics, int totalPrescriptions) {
        DoctorStatisticRes res = new DoctorStatisticRes();

        res.totalDiagnostics = totalDiagnostics;
        res.totalPrescriptions = totalPrescriptions;

        return res;
    }
}
