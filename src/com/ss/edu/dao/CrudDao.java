package com.ss.edu.dao;

import java.util.List;

public interface CrudDao<TEntity> {

	List<TEntity> findByField(String field, Object o);	
	
	TEntity findById(long id);

    List<TEntity> findAll();

    void save(TEntity entity);

    void deleteById(Long id);

    void delete(TEntity entity);

    void deleteAll();
    
    void update(TEntity entity);
    
    
}
