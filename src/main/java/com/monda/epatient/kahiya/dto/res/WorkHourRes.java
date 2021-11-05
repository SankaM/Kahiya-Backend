package com.monda.epatient.kahiya.dto.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.monda.epatient.kahiya.model.WorkHourEntity;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkHourRes {
    private UUID id;

    private String dayOfWeek;

    private String time;

    public static WorkHourRes build(WorkHourEntity w) {
        WorkHourRes res = null;

        if(w != null) {
            res = new WorkHourRes();

            res.id = w.getId();
            res.dayOfWeek = w.getDayOfWeek().name();
            res.time = w.getTime();
        }

        return res;
    }
}
