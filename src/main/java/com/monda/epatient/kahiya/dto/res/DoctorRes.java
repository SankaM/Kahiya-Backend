package com.monda.epatient.kahiya.dto.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.monda.epatient.kahiya.model.DoctorEntity;
import com.monda.epatient.kahiya.model.Gender;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoctorRes {
    private UUID id;

    private String name;

    private String profile;

    private Gender gender;

    private String speciality;

    private String mobilePhone;

    private String address1;

    private String address2;

    private String address3;

    private String zipCode;

    private Double doctorCost;

    private String imageUrl;

    private String generalWorkHour;

    public static DoctorRes buildSimple(DoctorEntity d) {
        DoctorRes res = null;

        if(d != null) {
            res = new DoctorRes();
            res.id = d.getId();
            res.name = d.getName();
            res.speciality = d.getSpeciality();
            res.imageUrl = d.getImageUrl();
            res.generalWorkHour = d.getGeneralWorkHour();
        }

        return res;
    }

    public static DoctorRes buildDetail(DoctorEntity d) {
        DoctorRes res = null;

        if(d != null) {
            res = new DoctorRes();
            res.id = d.getId();
            res.name = d.getName();
            res.profile = d.getProfile();
            res.imageUrl = d.getImageUrl();
            res.gender = d.getGender();
            res.speciality = d.getSpeciality();
            res.mobilePhone = d.getMobilePhone();
            res.address1 = d.getAddress1();
            res.address2 = d.getAddress2();
            res.address3 = d.getAddress3();
            res.zipCode = d.getZipCode();
            res.doctorCost = d.getDoctorCost();
            res.generalWorkHour = d.getGeneralWorkHour();
        }

        return res;
    }
}
