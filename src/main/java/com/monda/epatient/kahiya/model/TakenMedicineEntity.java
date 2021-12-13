package com.monda.epatient.kahiya.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "taken_medicine", schema = "kahiya")
@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TakenMedicineEntity {
    public enum TakenStatus {
        TAKEN, NOT_TAKEN,
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
    private LocalDateTime scheduledTakenDate;

    @Column(name = "taken_status_date")
    private LocalDateTime takenStatusDate;
}
