package com.monda.epatient.kahiya.dto.req;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTakenMedicineReq {
    private UUID takenMedicineId;

    private Boolean taken;
}
