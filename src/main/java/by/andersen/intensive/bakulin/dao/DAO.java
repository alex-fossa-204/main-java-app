package by.andersen.intensive.bakulin.dao;

import java.util.List;

public interface DAO <E, ID>{
	
	boolean save(E e);
	
	E getById(ID id);
	
	List<E> findAll();
	
	E update(E e);
	
	E delete(E e);
	
}
