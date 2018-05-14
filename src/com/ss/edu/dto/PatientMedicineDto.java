package com.ss.edu.dto;

import java.util.ArrayList;
import java.util.List;

public class PatientMedicineDto {

	private String patientLogin;
	private List<MedicineDto> medicines;
	
	public PatientMedicineDto(String patientLogin) {		
		this.patientLogin = patientLogin;
		this.medicines = new ArrayList<>();
	}
	public PatientMedicineDto(String patientLogin, List<MedicineDto> medicines) {
		this.patientLogin = patientLogin;
		this.medicines = medicines;
	}
	public String getPatientLogin() {
		return patientLogin;
	}
	public List<MedicineDto> getMedicines() {
		return medicines;
	}
	public void setPatientLogin(String patientLogin) {
		this.patientLogin = patientLogin;
	}
	public void setMedicines(List<MedicineDto> medicines) {
		this.medicines = medicines;
	}
	
	public void addMedicineDto(MedicineDto medicine) {
		getMedicines().add(medicine);
	}
}
