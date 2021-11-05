package com.monda.epatient.kahiya.model;

import lombok.*;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.UUID;

@Table(name = "work_hour", schema = "kahiya")
@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkHourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor;

    @Column(name = "day_of_week")
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    @Column(name = "time_")
    private String time;
}
