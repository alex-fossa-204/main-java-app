package by.andersen.intensive.bakulin.dao;

import by.andersen.intensive.bakulin.dao.exception.DAOException;
import by.andersen.intensive.bakulin.entity.Role;

public interface IRoleDAO extends DAO<Role>{
	
	Role findRoleByName(String roleName) throws DAOException;
	
}
