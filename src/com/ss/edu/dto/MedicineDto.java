package com.ss.edu.dto;

public class MedicineDto {
	
	private Long id;
	private String title;
	private String description;
	private Long patientId;
	
	public MedicineDto(Long id, String title, String description, Long patientId) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.patientId = patientId;
	}	

	public MedicineDto(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}	

}
