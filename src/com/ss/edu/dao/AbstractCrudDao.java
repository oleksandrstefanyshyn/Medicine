package com.ss.edu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ss.edu.db.ConnectionManager;
import com.ss.edu.entity.AEntity;
import com.ss.edu.utility.SqlProperty;

public abstract class AbstractCrudDao<TEntity extends AEntity> implements CrudDao<TEntity> {
		
	private String queryPrefix;
	public abstract String getQueryPrefix();
	
	public AbstractCrudDao() {
		this.queryPrefix = getQueryPrefix();
	}	

	@Override
	public List<TEntity> findByField(String field, Object obj) {
		String sql = SqlProperty.get(queryPrefix + ".findByField").replace("$field$", field);	
		List<TEntity> entities = new ArrayList<TEntity>();
		try (PreparedStatement preparedStatement = ConnectionManager
				.getInstance()
				.getConnection()
				.prepareStatement(sql)){			
			preparedStatement.setObject(1, obj);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				entities.add(createEntity(resultSet));
			}
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entities;			
	}		
	
	@Override
	public TEntity findById(long id) {
		//list.size if > 0
		return findByField("id", id).get(0);
	}

	
	@Override
	public List<TEntity> findAll() {
		String sql = SqlProperty.get(queryPrefix + ".findAll");	
		List<TEntity> entities = new ArrayList<TEntity>();
		try (PreparedStatement preparedStatement = ConnectionManager
				.getInstance()
				.getConnection()
				.prepareStatement(sql)){			
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				entities.add(createEntity(resultSet));
			}
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entities;			
	}

	@Override
	public void save(TEntity entity) {
		String sql = SqlProperty.get(queryPrefix + ".saveNew");	
		List<Object> params = getEntityParams(entity);			
		try (PreparedStatement preparedStatement = ConnectionManager
					.getInstance()
					.getConnection()
					.prepareStatement(sql))
			{
			for (int i = 1; i < params.size(); i++) {
				preparedStatement.setObject(i, params.get(i));
			}
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void deleteById(Long id) {
		String sql = SqlProperty.get(queryPrefix + ".deleteById");
		try (PreparedStatement preparedStatement = ConnectionManager
				.getInstance()
				.getConnection()
				.prepareStatement(sql)){
			preparedStatement.setObject(1, id);			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(TEntity element) {
		deleteById(element.getId());
	}

	@Override
	public void deleteAll() {
		String sql = SqlProperty.get(queryPrefix + ".deleteAll");
		try (Statement statement = ConnectionManager.getInstance().getConnection().createStatement()){
			statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	public void update(TEntity entity) {
		String sql = SqlProperty.get(queryPrefix + ".updateById");
		List<Object> params = getEntityParams(entity);
		try (PreparedStatement preparedStatement = ConnectionManager
					.getInstance()
					.getConnection()
					.prepareStatement(sql))
			{
			for (int i = 1; i < params.size(); i++) {
				preparedStatement.setObject(i, params.get(i));
			}
			preparedStatement.setObject(params.size(), params.get(0));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}	
	
	public abstract List<Object> getEntityParams(TEntity entity);
	public abstract TEntity createEntity(ResultSet resultSet) throws SQLException;
	
}
