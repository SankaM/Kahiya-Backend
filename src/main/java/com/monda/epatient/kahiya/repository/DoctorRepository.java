package com.monda.epatient.kahiya.repository;

import com.monda.epatient.kahiya.model.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, UUID> {
    // Todo: Low performance query. Find a way to tune-in the query
    @Query("SELECT d FROM DoctorEntity d WHERE lower(d.name) LIKE lower(concat('%',:name,'%'))")
    List<DoctorEntity> findByName(String name);

    List<DoctorEntity> findByMobilePhoneContains(String mobilePhone);
}
