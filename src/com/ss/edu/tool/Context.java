package com.ss.edu.tool;

import com.ss.edu.dao.MedicineDao;
import com.ss.edu.dao.PatientDao;
import com.ss.edu.service.MedicineService;
import com.ss.edu.service.LoginService;
import com.ss.edu.service.PatientMedicineService;
import com.ss.edu.service.PatientProfileService;

public final class Context {

	private static volatile Context instance = null;
	
	PatientDao patientDao;
	MedicineDao medicineDao;
	
	LoginService loginService;
	PatientProfileService patientProfileService;
	MedicineService medicineService;
	PatientMedicineService patientMedicineService;
	
	private Context() {
		initComponents();
	}
	
	public static Context getInstance() {
		if (instance == null) {
			synchronized (Context.class) {
				if (instance == null) {
					instance = new Context();
				}
			}
		}
		return instance;
	}
	
	private void initComponents() {
		patientDao = new PatientDao();
		medicineDao = new MedicineDao();
		
		loginService = new LoginService(patientDao);
		patientProfileService = new PatientProfileService(patientDao);
		medicineService = new MedicineService(medicineDao);
		patientMedicineService = new PatientMedicineService(patientDao, medicineDao);		
	}

	public PatientDao getPatientDao() {
		return patientDao;
	}

	public MedicineDao getMedicineDao() {
		return medicineDao;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public PatientProfileService getPatientProfileService() {
		return patientProfileService;
	}

	public MedicineService getMedicineService() {
		return medicineService;
	}

	public PatientMedicineService getPatientMedicineService() {
		return patientMedicineService;
	}	
}
