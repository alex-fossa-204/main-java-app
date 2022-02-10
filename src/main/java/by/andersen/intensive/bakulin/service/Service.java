package by.andersen.intensive.bakulin.service;

import java.util.List;

public interface Service <E, ID> {
	
	boolean save(E e);
	
	E getById(ID id);
	
	List<E> findAll();
	
	E update(E e);
	
	E delete(E e);

}
