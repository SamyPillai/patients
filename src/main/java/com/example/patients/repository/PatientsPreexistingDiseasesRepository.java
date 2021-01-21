package com.example.patients.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.patients.entity.Patients;
import com.example.patients.entity.PatientsPreexistingDiseases;
import com.example.patients.entity.PatientsPreexistingDiseasesIdentity;

@Repository
public interface PatientsPreexistingDiseasesRepository extends JpaRepository<PatientsPreexistingDiseases, PatientsPreexistingDiseasesIdentity> {

	List<PatientsPreexistingDiseases> findByPatientId(Long patientId);

}
