package com.monda.epatient.kahiya.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "dosage", schema = "wahiya")
@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DosageEntity {
    public enum DosageRule {
        BEFORE_MEAL,
        AFTER_MEAL
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "prescription_id")
    private PrescriptionEntity prescription;

    @ManyToOne
    private DrugEntity drug;

    @Column(name = "treatment_days")
    private Integer treatmentDays;

    @Column(name = "times_per_day")
    private Integer timesPerDay;

    @Column(name = "dosage_rule")
    @Enumerated(EnumType.STRING)
    private DosageRule dosageRule;

    @Column(name = "dosage_count")
    private Double dosageCount;

    @Column(name = "drug_cost")
    private Double drugCost;
}
