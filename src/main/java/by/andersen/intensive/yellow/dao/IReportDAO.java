package by.andersen.intensive.yellow.dao;

import java.util.List;

import by.andersen.intensive.yellow.dao.exception.DAOException;
import by.andersen.intensive.yellow.entity.Report;

public interface IReportDAO extends DAO<Report> {
	
	Report findReportByTitle(String title) throws DAOException;
	
	List<Report> findUserReportsAll(String username) throws DAOException;
}
