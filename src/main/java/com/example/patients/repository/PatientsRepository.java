package com.example.patients.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.patients.entity.Patients;

@Repository
public interface PatientsRepository extends JpaRepository<Patients, Long> {

	Patients findByPatientId(Long patientId);
	
	@Transactional    
	@Modifying
	@Query(value="DELETE FROM patients_health WHERE patient_id=?1 and symptoms=?2 and date =?3", nativeQuery = true)
	void deleteBySymptomsAndDate(String patientId,String symptoms,String date);
	
	@Transactional    
	@Modifying
	@Query(value="DELETE FROM patients_preexisting_diseases WHERE patient_id=?1 and disease=?2", nativeQuery = true)
	void deleteByDiseases(String patientId,String disease);

}
