package by.andersen.intensive.yellow.team.dao;

import java.util.Date;
import java.util.List;

import by.andersen.intensive.yellow.team.dao.exception.DAOException;
import by.andersen.intensive.yellow.team.entity.impl.Report;

public interface IReportDAO extends DAO<Report> {
	
	Report findReportByTitle(String title) throws DAOException;
	
	List<Report> findUserReportsAllByDate(String username, String date) throws DAOException;
}
