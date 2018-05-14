package com.ss.edu.service;

import java.util.List;

import com.ss.edu.dao.MedicineDao;
import com.ss.edu.dto.MedicineDto;
import com.ss.edu.entity.MedicineEntity;

public class MedicineService {
	
	private MedicineDao medicineDao;

	public MedicineService() {
		this.medicineDao = new MedicineDao();
	}

	public MedicineService(MedicineDao medicineDao) {
		this.medicineDao = medicineDao;
	}
	
	public MedicineDto getMedicineDto(Long id) {
		MedicineEntity medicineEntity = medicineDao.findById(id);
		return new MedicineDto(medicineEntity.getId(), medicineEntity.getTitle(), 
				medicineEntity.getDescription(), medicineEntity.getPatientId());
	}
	
	public boolean setMedicineDto(MedicineDto medicineDto) {
		boolean result = false;
		MedicineEntity medicineEntity = new MedicineEntity(/*why not???*/medicineDto.getId(), medicineDto.getTitle(), 
				medicineDto.getDescription(), medicineDto.getPatientId());		
		
		if (medicineDto.getId() < 0) {
			if (!isExistId(medicineEntity.getId())) {				
				medicineDao.save(medicineEntity);
				System.out.println("Medicine " + medicineEntity + " created");
				result = true;
			}
		} else {
			medicineDao.update(medicineEntity);
			System.out.println("Medicine " + medicineEntity + " updated");
			result = true;
		}
		return result;		
	}
	
	public boolean removeMedicine(MedicineDto medicineDto) {
		boolean result = false;
		try {
			medicineDao.deleteById(medicineDto.getId());
			result = true;
		} catch (RuntimeException e) {
			System.out.println("Medicine not found, message: " + e.getMessage());		
		}
		return result;
	}
	
	public boolean isExistId(Long id) {
		boolean result = true;			
			List<MedicineEntity> list = medicineDao.findByField("id", id);			
			if (list.isEmpty()) {
				result = false;
				return result;
			}		
		return result;
	}
}