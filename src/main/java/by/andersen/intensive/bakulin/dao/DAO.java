package by.andersen.intensive.bakulin.dao;

import java.util.List;

import by.andersen.intensive.bakulin.dao.exception.DAOException;
import by.andersen.intensive.bakulin.entity.impl.Entity;

public interface DAO <E extends Entity>{
	
	boolean save(E e) throws DAOException;
	
	E getById(long id) throws DAOException;
	
	List<E> findAll() throws DAOException;
	
	boolean update(E e) throws DAOException;
	
	boolean delete(long id) throws DAOException;
	
}
