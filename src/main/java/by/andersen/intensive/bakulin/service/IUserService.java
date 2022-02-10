package by.andersen.intensive.bakulin.service;

import by.andersen.intensive.bakulin.model.User;

public interface IUserService extends Service<User, Long>{
	
	User findByUserName(String userName);

}
