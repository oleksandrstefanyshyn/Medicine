package com.ss.edu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.edu.entity.PatientEntity;

public class PatientDao extends AbstractCrudDao<PatientEntity> {	
	
	@Override
	public String getQueryPrefix() {		
		return "patient";
	}
	
	@Override
	public List<Object> getEntityParams(PatientEntity entity) {
		List<Object> params = new ArrayList<>();
		params.add(entity.getId());
		params.add(entity.getName());
		params.add(entity.getLogin());
		params.add(entity.getPassword());
		params.add(entity.getAge());
		return params;
	}

	@Override
	public PatientEntity createEntity(ResultSet resultSet) throws SQLException {
		PatientEntity patientEntity = new PatientEntity();
		patientEntity.setId(resultSet.getLong(1));
		patientEntity.setName(resultSet.getString(2));
		patientEntity.setLogin(resultSet.getString(3));
		patientEntity.setPassword(resultSet.getString(4));
		patientEntity.setAge(resultSet.getInt(5));
		return patientEntity;	
	}
}
