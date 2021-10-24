package com.monda.epatient.kahiya.repository;

import com.monda.epatient.kahiya.model.DosageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DosageRepository extends JpaRepository<DosageEntity, UUID> {
}
