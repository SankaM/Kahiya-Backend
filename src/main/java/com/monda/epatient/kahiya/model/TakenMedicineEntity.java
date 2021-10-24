package com.monda.epatient.kahiya.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Table(name = "drug", schema = "wahiya")
@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TakenMedicineEntity {
    public enum TakenStatus {
        TAKEN, PASS
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "dosage_id")
    private DosageEntity dosage;

    @Column(name = "taken_status")
    @Enumerated(EnumType.STRING)
    private TakenStatus takenStatus;

    @Column(name = "scheduled_taken_date")
    private LocalDate scheduledTakenDate;

    @Column(name = "taken_status_date")
    private LocalDate takenStatusDate;
}
