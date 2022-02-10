package by.andersen.intensive.bakulin.dao.implementation.user;

import java.util.List;

import by.andersen.intensive.bakulin.dao.IUserDAO;
import by.andersen.intensive.bakulin.model.User;

public class UserDAO implements IUserDAO {

	@Override
	public boolean save(User e) {
		return false;
	}

	@Override
	public User getById(Long id) {
		return null;
	}

	@Override
	public List<User> findAll() {
		return null;
	}

	@Override
	public User update(User e) {
		return null;
	}

	@Override
	public User delete(User e) {
		return null;
	}

	@Override
	public User findByUserName(String userName) {
		return null;
	}

}
