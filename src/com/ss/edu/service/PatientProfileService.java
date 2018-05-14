package com.ss.edu.service;

import java.util.List;


import com.ss.edu.dao.PatientDao;
import com.ss.edu.dto.PatientDto;
import com.ss.edu.entity.PatientEntity;

public class PatientProfileService {

	private PatientDao patientDao;
	
	public PatientProfileService() {
		this.patientDao = new PatientDao();
	}

	public PatientProfileService(PatientDao patientDao) {
		this.patientDao = patientDao;
	}

	public PatientDto getPatientDto(String login) {
		PatientEntity patientEntity;
		PatientDto patientDto;
		if (isExistLogin(login)) {		
			try {
				patientEntity = patientDao.findByField(PatientEntity.PATIENT_ENTITY_LOGIN, login).get(0);
				patientDto = new PatientDto(patientEntity.getId(), patientEntity.getName(), 
						patientEntity.getLogin(), patientEntity.getPassword(), patientEntity.getAge());	
				return patientDto;	
			} catch (Exception e) {
				return null;
			}			
		}
		return null;
	}
	
	public boolean setPatientDto(PatientDto patientDto) {
		boolean result = false;
		PatientEntity patientEntity = new PatientEntity(/*why not???*/patientDto.getId(), patientDto.getName(), 
				patientDto.getLogin(), patientDto.getPassword(), patientDto.getAge());
		
		if (patientDto.getId() < 0) {
			if (!isExistLogin(patientEntity.getLogin())) {
				patientDao.save(patientEntity);
				//System.out.println("Patient " + patientEntity + " created");
				result = true;
			}
		} else {
			patientDao.update(patientEntity);
			//System.out.println("Patient " + patientEntity + " updated");
			result = true;
		}
		return result;
	}
	
	public void deletePatientDtoById(Long id) {
		patientDao.deleteById(id);
	}
	
	public void deletePatientDto(PatientDto patientDto) {
		patientDao.deleteById(patientDto.getId());;
	}
	
	public boolean isExistLogin(String login) {
		boolean result = true;	
		try {
			List<PatientEntity> list = patientDao.findByField(PatientEntity.PATIENT_ENTITY_LOGIN, login);			
			if (list.isEmpty()) {
				//System.out.println("Login " + login + " doesn't exists");
				result = false;
				return result;
			}		
			//System.out.println("Login " + login + " exists");
		} catch (Exception e) {
			System.out.println("Patient not found. SQLException: " + e.getMessage());
		}
		return result;
	}	
}