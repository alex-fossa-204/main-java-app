package by.andersen.intensive.bakulin.dao;

import by.andersen.intensive.bakulin.dao.exception.DAOException;
import by.andersen.intensive.bakulin.entity.User;

public interface IUserDAO extends DAO <User> {
	
	User findByUserName(String userName) throws DAOException;

}
