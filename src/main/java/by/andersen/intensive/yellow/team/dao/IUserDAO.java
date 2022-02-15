package by.andersen.intensive.yellow.team.dao;

import by.andersen.intensive.yellow.team.dao.exception.DAOException;
import by.andersen.intensive.yellow.team.entity.User;

public interface IUserDAO extends DAO <User> {
	
	User findByUserName(String userName) throws DAOException;

}
