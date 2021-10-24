//package com.monda.epatient.wahiya._old.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.monda.epatient.wahiya._old.commons.AccountStatus;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.ToString;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@ToString(exclude = "patientSessions")
//@EqualsAndHashCode(exclude = "patientSessions")
//@Data
//@Entity
//@Table(name = "patient_login", schema = "kahiya")
//public class PatientLoginEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="login_id")
//    private Long loginId;
//    @Column(name="user_name")
//    private String userName;
//    @Column(name="password")
//    private String password;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
//    private PatientEntity patientEntity;
//    @Column(name="fail_attempts")
//    private Integer failAttempts;
//    @Enumerated(EnumType.STRING)
//    @Column(name="account_status")
//    private AccountStatus accountStatus;
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "patientLogin", orphanRemoval = true)
//    private Set<PatientSessionEntity> patientSessions;
//}
