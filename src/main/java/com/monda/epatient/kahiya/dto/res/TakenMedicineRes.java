package com.monda.epatient.kahiya.dto.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.monda.epatient.kahiya.model.TakenMedicineEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TakenMedicineRes {
    private UUID id;

    private DosageRes dosage;

    private TakenMedicineEntity.TakenStatus takenStatus;

    private LocalDateTime scheduledTakenDate;

    private LocalDateTime takenStatusDate;

    public static TakenMedicineRes build(TakenMedicineEntity t) {
        TakenMedicineRes res = null;

        if(t != null) {
            res = new TakenMedicineRes();

            res.id = t.getId();
            res.dosage = DosageRes.buildDetail(t.getDosage());
            res.takenStatus = t.getTakenStatus();
            res.scheduledTakenDate = t.getScheduledTakenDate();
            res.takenStatusDate = t.getTakenStatusDate();
        }

        return res;
    }
}
