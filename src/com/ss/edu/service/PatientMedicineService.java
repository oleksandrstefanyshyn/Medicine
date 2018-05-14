package com.ss.edu.service;


import com.ss.edu.dao.MedicineDao;
import com.ss.edu.dao.PatientDao;
import com.ss.edu.dto.MedicineDto;
import com.ss.edu.dto.LoginDto;
import com.ss.edu.dto.PatientMedicineDto;
import com.ss.edu.entity.MedicineEntity;
import com.ss.edu.entity.PatientEntity;

public class PatientMedicineService {
	
	private PatientDao patientDao;
	private MedicineDao medicineDao;
	public PatientMedicineService() {
		this.patientDao = new PatientDao();
		this.medicineDao = new MedicineDao();
	}
	public PatientMedicineService(PatientDao patientDao, MedicineDao medicineDao) {
		this.patientDao = patientDao;
		this.medicineDao = medicineDao;
	}
	
	public PatientMedicineDto getPatientMedicines(LoginDto loginDto) {
		PatientEntity patientEntity = patientDao
				.findByField(PatientEntity.PATIENT_ENTITY_LOGIN, loginDto.getLogin()).get(0);
		PatientMedicineDto patientMedicineDto = new PatientMedicineDto(patientEntity.getLogin());
		
		for (MedicineEntity doctorEntity : medicineDao.findAll()) {
			if (doctorEntity.getPatientId() == patientEntity.getId()) {
				
				MedicineDto doctorDto = new MedicineDto(doctorEntity.getId(), 
						doctorEntity.getTitle(), 
						doctorEntity.getDescription(), 
						doctorEntity.getPatientId());
				patientMedicineDto.addMedicineDto(doctorDto);		
			}
		}		
		return patientMedicineDto;
	}
}