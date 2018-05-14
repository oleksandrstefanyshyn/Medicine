package com.ss.edu.entity;

public class MedicineEntity extends AEntity{
	
	private Long id;
	private String title;
	private String description;
	private Long patientId;
	
	
	
	public MedicineEntity() {		
	}
	
	public MedicineEntity(Long id, String title, String description, Long patientId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.patientId = patientId;
	}
	public MedicineEntity(String title, String description, Long patientId) {
		this.title = title;
		this.description = description;
		this.patientId = patientId;
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
	@Override
	public String toString() {
		return "MedicineEntity [id=" + id + ", title=" + title + ", description=" + description + ", patientId=" + patientId
				+ "]";
	}	
}
