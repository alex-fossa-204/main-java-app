package by.andersen.intensive.bakulin.dao;

import by.andersen.intensive.bakulin.model.User;

public interface IUserDAO extends DAO <User, Long> {
	
	User findByUserName(String userName);

}
