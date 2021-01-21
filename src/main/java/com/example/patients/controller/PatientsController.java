package com.example.patients.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.patients.entity.Patients;
import com.example.patients.entity.PatientsHealth;
import com.example.patients.entity.PatientsPreexistingDiseases;
import com.example.patients.entity.PatientsPreexistingDiseasesIdentity;
import com.example.patients.repository.PatientsHealthRepository;
import com.example.patients.repository.PatientsPreexistingDiseasesRepository;
import com.example.patients.repository.PatientsRepository;
import com.example.patients.service.PatientsService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/patients")
public class PatientsController {

	@Autowired
	private PatientsService patientsService;
	
	@Autowired	
	private PatientsRepository patientsRepository;
	
	@Autowired	
	private PatientsHealthRepository patientsHealthRepository;
	
	@Autowired	
	private PatientsPreexistingDiseasesRepository patientsPreexistingDiseasesRepository;
	
	// Insert a Patient - Working 
	@PostMapping("/")
	public Patients savePatients(@RequestBody Patients patients) {
		return patientsService.savePatients(patients);
	}
	
	//Update Patient - Working
	@PutMapping("/{id}")
	public Patients updatePatients(@PathVariable Long id, @RequestBody Patients patientDetails){
		
		Patients patient = patientsRepository.findByPatientId(id);
		patient.setFirstName(patientDetails.getFirstName());
		patient.setLastName(patientDetails.getLastName());
		patient.setAddress(patientDetails.getAddress());
		patient.setCity(patientDetails.getCity());
		patient.setContactNumber(patientDetails.getContactNumber());
		patient.setDateOfBirth(patientDetails.getDateOfBirth());
		patient.setEmailId(patientDetails.getEmailId());
		patient.setGender(patientDetails.getGender());
		patient.setHeight(patientDetails.getHeight());
		patient.setWeight(patientDetails.getWeight());
		patient.setProfession(patientDetails.getProfession());
		patient.setState(patientDetails.getState());
		patient.setZipCode(patientDetails.getZipCode());
		
		Patients updatedPatient = patientsRepository.save(patient);
		
		return updatedPatient;	
	}		
	
	// Get a Patient - Working
	@GetMapping("/{id}")
	public Patients findPatientsById(@PathVariable("id") Long PatientID) {
		return patientsService.findPatientsById(PatientID);
	}
	
	@GetMapping("/get_all/")
	public List<Patients> showPatients() {
		List<Patients> patients = this.patientsRepository.findAll();
		return patients;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletePatients(@PathVariable("id") Long PatientId) {
		patientsService.deletePatients(PatientId);
	}
	
	@DeleteMapping("/health_delete/{id}")
	public void deletePatientsHealth(@PathVariable("id") String PatientId) {
		String[] key = PatientId.split(",");
		String iden = key[0];
		String symptoms = key[1];
		String date = key[2];
		System.out.println(iden);
		System.out.println(symptoms);
		System.out.println(date);
	
		patientsService.deletePatientsHealth(iden,symptoms,date);
	}
	
	@DeleteMapping("/disease_delete/{id}")
	public void deletePatientsDiseases(@PathVariable("id") String PatientId) {
		String[] key = PatientId.split(",");
		String iden = key[0];
		String disease = key[1];
		System.out.println(iden);
		System.out.println(disease);
	
		patientsService.deletePatientsDiseases(iden,disease);
	}
	
	// Insert a Disease - Working
	@PostMapping("/disease_insert/")
	public PatientsPreexistingDiseases savePatientsDiseases(@RequestBody PatientsPreexistingDiseases patients_diseases) {
		return patientsService.savePatientsDiseases(patients_diseases);
	}
	
	// Get the list of diseases - Working
	@GetMapping("/disease_get/{id}")
	public List<PatientsPreexistingDiseases> getPatientsPreexistingDiseasesById(@PathVariable Long id) {
		List<PatientsPreexistingDiseases> patient_diseases = patientsPreexistingDiseasesRepository.findByPatientId(id);
		return patient_diseases;
	}
	
	//Update Diseases - Working
	@PutMapping("/disease_update/{id}") 
	public PatientsPreexistingDiseases updatePatientsPreexistingDiseases(@PathVariable Long id, 
			@RequestBody PatientsPreexistingDiseases patientDiseases){
		
		List<PatientsPreexistingDiseases> patient_diseases = patientsPreexistingDiseasesRepository.findByPatientId(id);

		Iterator<PatientsPreexistingDiseases> iterator = (Iterator<PatientsPreexistingDiseases>) patient_diseases.iterator();
		
		PatientsPreexistingDiseases diseases = new PatientsPreexistingDiseases();
		
		 while (iterator.hasNext()) {
			 PatientsPreexistingDiseases disease = iterator.next();
		        if (disease.getDisease().equals(patientDiseases.getDisease())) {
		            diseases = disease;
		        	break;
		        }
		    }
		 
		diseases.setAdditionalInfo(patientDiseases.getAdditionalInfo());
		PatientsPreexistingDiseases updatedPatient = patientsPreexistingDiseasesRepository.save(diseases);
		
		return updatedPatient;		
	}		
	
	// Insert Patients Health - Working
	@PostMapping("/health_insert/")
	public PatientsHealth savePatientsHealth(@RequestBody PatientsHealth patients_health) {
		return patientsService.savePatientsHealth(patients_health);
	}
	
	// Get the Patients Health - Working
	@GetMapping("/health_get/{id}")
	public List<PatientsHealth> getPatientsHealthById(@PathVariable Long id) {
		List<PatientsHealth> patient_health = patientsHealthRepository.findByPatientId(id);
		return patient_health;
	}
	
	//Update Patients Health - Working
	@PutMapping("/health_update/{id}") 
	public PatientsHealth updatePatientsHealth(@PathVariable Long id, 
			@RequestBody PatientsHealth patientHealth){
		
		List<PatientsHealth> patient_health = patientsHealthRepository.findByPatientId(id);

		Iterator<PatientsHealth> iterator = (Iterator<PatientsHealth>) patient_health.iterator();
		
		PatientsHealth health_info = new PatientsHealth();
		
		 while (iterator.hasNext()) {
			 PatientsHealth health = iterator.next();
		        if (health.getSymptoms().equals(patientHealth.getSymptoms())
		        		&& health.getDate().equals(patientHealth.getDate())) {
		            health_info = health;
		        	break;
		        }
		    }
		 
		health_info.setTime(patientHealth.getTime());
		health_info.setAdditionalInfo(patientHealth.getAdditionalInfo());
		PatientsHealth updatedPatient = patientsHealthRepository.save(health_info);
		
		return updatedPatient;		
	}		

}
