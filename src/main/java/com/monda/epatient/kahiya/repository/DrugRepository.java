package com.monda.epatient.kahiya.repository;

import com.monda.epatient.kahiya.model.DrugEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DrugRepository extends JpaRepository<DrugEntity, UUID> {
}
