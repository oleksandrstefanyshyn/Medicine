package com.ss.edu.service;

import java.util.List;



import com.ss.edu.dao.PatientDao;
import com.ss.edu.dto.LoginDto;
import com.ss.edu.entity.PatientEntity;

public class LoginService {

	private PatientDao patientDao;

	public LoginService() {
		this.patientDao = new PatientDao();
	}

	public LoginService(PatientDao patientDao) {
		//super();
		this.patientDao = patientDao;
	}
	
	public boolean isLogged(LoginDto loginDto) {
		boolean result = true;
		List<PatientEntity> users = null;
		try {
			users = patientDao.findByField(PatientEntity.PATIENT_ENTITY_LOGIN, loginDto.getLogin());
		} catch (RuntimeException e) {
			// Logging Exception
			System.out.println("RuntimeException, message: " + e.getMessage());
			result = false;
		}
		result = result && (users.size() == 1) && (users.get(0).getPassword().equals(loginDto.getPassword()));
		return result;
	}
	
}
