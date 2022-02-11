package by.andersen.intensive.bakulin.service;

import by.andersen.intensive.bakulin.entity.Role;

public interface IRoleService extends Service<Role, Long>{
	
	Role findRoleByName(String roleName);
	
}
