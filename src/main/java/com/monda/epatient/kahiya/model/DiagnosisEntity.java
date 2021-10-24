package com.monda.epatient.kahiya.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "diagnosis", schema = "wahiya")
@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosisEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", unique = true)
    private String name;
}
