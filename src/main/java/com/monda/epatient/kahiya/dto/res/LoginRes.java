package com.monda.epatient.kahiya.dto.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.monda.epatient.kahiya.model.PatientEntity;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginRes {
    private UUID doctorId;

    private String firstName;

    private String lastName;

    private String userName;

    private String imageUrl;

    public static LoginRes buildDetail(PatientEntity p) {
        LoginRes res = null;

        if (p != null) {
            res = new LoginRes();
            res.doctorId = p.getId();
            res.firstName = p.getFirstName();
            res.lastName = p.getLastName();
            res.imageUrl = p.getImageUrl();
        }

        return res;
    }
}
