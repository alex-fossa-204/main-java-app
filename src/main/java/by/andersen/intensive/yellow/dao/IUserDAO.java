package by.andersen.intensive.yellow.dao;

import by.andersen.intensive.yellow.dao.exception.DAOException;
import by.andersen.intensive.yellow.entity.User;

public interface IUserDAO extends DAO <User> {
	
	User findByUserName(String userName) throws DAOException;

}
