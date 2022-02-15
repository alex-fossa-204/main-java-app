package by.andersen.intensive.yellow.team.dao;

import java.util.List;

import by.andersen.intensive.yellow.team.dao.exception.DAOException;
import by.andersen.intensive.yellow.team.entity.Report;

public interface IReportDAO extends DAO<Report> {
	
	Report findReportByTitle(String title) throws DAOException;
	
	List<Report> findUserReportsAll(String username) throws DAOException;
}
