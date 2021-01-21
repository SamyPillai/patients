package com.example.patients.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.patients.entity.Patients;
import com.example.patients.entity.PatientsHealth;
import com.example.patients.entity.PatientsPreexistingDiseases;
import com.example.patients.entity.PatientsPreexistingDiseasesIdentity;
import com.example.patients.repository.PatientsHealthRepository;
import com.example.patients.repository.PatientsPreexistingDiseasesRepository;
import com.example.patients.repository.PatientsRepository;

@Service
public class PatientsService {

	@Autowired
	private PatientsRepository patientsRepository;
	
	@Autowired
	private PatientsHealthRepository patientsHealthRepository;
	
	@Autowired
	private PatientsPreexistingDiseasesRepository patientsPreexistingDiseasesRepository;

	public Patients savePatients(Patients patients) {
		
		return patientsRepository.save(new Patients(patients.getFirstName(),patients.getLastName(),patients.getDateOfBirth(),
				patients.getGender(),patients.getWeight(),patients.getHeight(),patients.getContactNumber(),patients.getEmailId(),
				patients.getProfession(),patients.getAddress(),patients.getCity(),patients.getState(),patients.getZipCode()));
	}

	public Patients findPatientsById(Long patientId) {
		return patientsRepository.findByPatientId(patientId);
	}

	public void deletePatients(Long patientId) {
		patientsRepository.deleteById(patientId);
	}
	
	public void deletePatientsHealth(String iden, String symptoms, String date) {
		patientsRepository.deleteBySymptomsAndDate(iden,symptoms,date);
	}
	
	public void deletePatientsDiseases(String iden, String disease) {
		patientsRepository.deleteByDiseases(iden,disease);
	}
	
	public PatientsPreexistingDiseases savePatientsDiseases(PatientsPreexistingDiseases patients_diseases) {
		return patientsPreexistingDiseasesRepository.save(new PatientsPreexistingDiseases(patients_diseases.getPatientId(), 
				patients_diseases.getDisease(),patients_diseases.getAdditionalInfo()));
	}

	public PatientsHealth savePatientsHealth(PatientsHealth patients_health) {
		return patientsHealthRepository.save(new PatientsHealth(patients_health.getPatientId(),patients_health.getSymptoms(),
				patients_health.getDate(),patients_health.getTime(),patients_health.getAdditionalInfo()));
	}
	
}
