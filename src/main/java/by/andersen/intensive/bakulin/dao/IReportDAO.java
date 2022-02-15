package by.andersen.intensive.bakulin.dao;

import java.util.List;

import by.andersen.intensive.bakulin.dao.exception.DAOException;
import by.andersen.intensive.bakulin.entity.Report;

public interface IReportDAO extends DAO<Report> {
	
	Report findReportByTitle(String title) throws DAOException;
	
	List<Report> findUserReportsAll(String username) throws DAOException;
}
