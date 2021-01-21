package com.example.patients.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class PatientsPreexistingDiseasesIdentity implements Serializable {
	
	@GeneratedValue
    @Column(name = "patientId")
	private Long patientId;
	
    @Column(name = "disease")
	private String disease;
	
	public PatientsPreexistingDiseasesIdentity() {
		
	}

	public PatientsPreexistingDiseasesIdentity(Long patientId, String disease) {
		super();
		this.patientId = patientId;
		this.disease = disease;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disease == null) ? 0 : disease.hashCode());
		result = prime * result + ((patientId == null) ? 0 : patientId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatientsPreexistingDiseasesIdentity other = (PatientsPreexistingDiseasesIdentity) obj;
		if (disease == null) {
			if (other.disease != null)
				return false;
		} else if (!disease.equals(other.disease))
			return false;
		if (patientId == null) {
			if (other.patientId != null)
				return false;
		} else if (!patientId.equals(other.patientId))
			return false;
		return true;
	}

}
