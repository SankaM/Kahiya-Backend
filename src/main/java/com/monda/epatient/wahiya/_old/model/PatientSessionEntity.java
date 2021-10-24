//package com.monda.epatient.wahiya._old.model;
//
//import lombok.*;
//
//import javax.persistence.*;
//
//@ToString(exclude = "patientLogin")
//@EqualsAndHashCode(exclude = "patientLogin")
//@Data
//@Entity
//@Table(name = "patient_session", schema = "kahiya")
//@NoArgsConstructor
//@AllArgsConstructor
//public class PatientSessionEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="session_id")
//    private Long sessionId;
//    @ManyToOne
//    @JoinColumn(name = "login_id", nullable = false)
//    private PatientLoginEntity patientLogin;
//    @Column(name = "token", length = 1000)
//    private String token;
//
//    public PatientSessionEntity(PatientLoginEntity patientLogin, String token) {
//        this.patientLogin = patientLogin;
//        this.token = token;
//    }
//}
