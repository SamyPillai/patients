package com.example.patients.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.patients.entity.Patients;
import com.example.patients.entity.PatientsHealth;
import com.example.patients.entity.PatientsHealthIdentity;
import com.example.patients.entity.PatientsPreexistingDiseases;
import com.example.patients.entity.PatientsPreexistingDiseasesIdentity;

@Repository
public interface PatientsHealthRepository extends JpaRepository<PatientsHealth, PatientsHealthIdentity> {

	List<PatientsHealth> findByPatientId(Long patientId);

}
