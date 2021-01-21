package com.example.patients.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.patients.entity.Patients;
import com.example.patients.entity.PatientsPreexistingDiseasesIdentity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(PatientsPreexistingDiseasesIdentity.class)
@Table(name = "patients_preexisting_diseases")
public class PatientsPreexistingDiseases {
	
	@Id
    @Column(name = "patientId")
	private Long patientId;
	
	@Id
    @Column(name = "disease")
	private String disease;
	
	@Column(name = "additionalInfo")
	private String additionalInfo;
	
	public PatientsPreexistingDiseases() {
		
	}

	public PatientsPreexistingDiseases(Long patientId, String disease, String additionalInfo) {
		super();
		this.patientId = patientId;
		this.disease = disease;
		this.additionalInfo = additionalInfo;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	
}
