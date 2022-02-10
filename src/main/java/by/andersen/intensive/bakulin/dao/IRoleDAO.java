package by.andersen.intensive.bakulin.dao;

import by.andersen.intensive.bakulin.model.Role;

public interface IRoleDAO extends DAO<Role, Long>{
	
	Role findRoleByName(String roleName);
	
}
