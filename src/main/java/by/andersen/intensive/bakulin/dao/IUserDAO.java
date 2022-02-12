package by.andersen.intensive.bakulin.dao;

import java.util.List;

import by.andersen.intensive.bakulin.dao.exception.DAOException;
import by.andersen.intensive.bakulin.entity.User;
import by.andersen.intensive.bakulin.service.exception.ServiceException;

public interface IUserDAO extends DAO <User> {
	
	User findByUserName(String userName) throws DAOException;

}
