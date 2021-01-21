package com.example.patients.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(PatientsHealthIdentity.class)
@Table(name="patients_health")
public class PatientsHealth implements Serializable {
	
	@Id
    @Column(name = "patientId")
	private Long patientId;
	
	@Id
    @Column(name = "symptoms")
	private String symptoms;
	
	@Id
    @Column(name = "date")
    private LocalDate date;
	
	@Column(name = "time")
	private LocalTime time;
	
	@Column(name = "additionalInfo")
	private String additionalInfo;
	
	public PatientsHealth() {
		
	}

	public PatientsHealth(Long patientId, String symptoms, LocalDate date, LocalTime time, String additionalInfo) {
		super();
		this.patientId = patientId;
		this.symptoms = symptoms;
		this.date = date;
		this.time = time;
		this.additionalInfo = additionalInfo;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	
}
