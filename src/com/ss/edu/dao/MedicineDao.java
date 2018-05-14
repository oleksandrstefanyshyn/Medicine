package com.ss.edu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.edu.entity.MedicineEntity;

public class MedicineDao extends AbstractCrudDao<MedicineEntity> {

	@Override
	public String getQueryPrefix() {
		return "medicine";
	}
	
	@Override
	public List<Object> getEntityParams(MedicineEntity entity) {
		List<Object> params = new ArrayList<>();
		params.add(entity.getId());
		params.add(entity.getTitle());
		params.add(entity.getDescription());
		params.add(entity.getPatientId());
		return params;
	}

	@Override
	public MedicineEntity createEntity(ResultSet resultSet) throws SQLException {
		MedicineEntity medicineEntity = new MedicineEntity();
		medicineEntity.setId((resultSet.getLong(1)));
		medicineEntity.setTitle(resultSet.getString(2));
		medicineEntity.setDescription(resultSet.getString(3));
		medicineEntity.setPatientId(resultSet.getLong(4));
		return medicineEntity;
	}
}
