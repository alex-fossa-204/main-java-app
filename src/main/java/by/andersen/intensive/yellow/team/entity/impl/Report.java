package by.andersen.intensive.yellow.team.entity.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import by.andersen.intensive.yellow.team.entity.Entity;
import by.andersen.intensive.yellow.team.entity.dto.UserDTO;

public class Report extends Entity implements Serializable {
	
	private static final long serialVersionUID = -3924742283383522551L;

	private String reportTitle;
	
	private String reportBody;
	
	private Date reportDate;
	
	private UserDTO reportedByUser;
	
	private long reporterId;
	
	private int laborCost;

	public Report(String reportTitle, String reportBody, Date reportDate, UserDTO reportedBy, int laborCost) {
		super();
		this.reportTitle = reportTitle;
		this.reportBody = reportBody;
		this.reportDate = reportDate;
		this.reportedByUser = reportedBy;
		this.laborCost = laborCost;
	}
	
	public Report(String reportTitle, String reportBody, long reporterId, int laborCost) {
		super();
		this.reportTitle = reportTitle;
		this.reportBody = reportBody;
		this.reporterId = reporterId;
		this.laborCost = laborCost;
	}

	public Report() {
		super();
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public String getReportBody() {
		return reportBody;
	}

	public void setReportBody(String reportBody) {
		this.reportBody = reportBody;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public UserDTO getReportedBy() {
		return reportedByUser;
	}

	public void setReportedBy(UserDTO reportedBy) {
		this.reportedByUser = reportedBy;
	}
	
	public long getReporterId() {
		return reporterId;
	}

	public void setReporterId(long reporterId) {
		this.reporterId = reporterId;
	}

	public int getLaborCost() {
		return laborCost;
	}

	public void setLaborCost(int laborCost) {
		this.laborCost = laborCost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(laborCost, reportBody, reportDate, reportTitle, reportedByUser);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Report other = (Report) obj;
		return laborCost == other.laborCost && Objects.equals(reportBody, other.reportBody)
				&& Objects.equals(reportDate, other.reportDate) && Objects.equals(reportTitle, other.reportTitle)
				&& Objects.equals(reportedByUser, other.reportedByUser);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Report [reportTitle=");
		builder.append(reportTitle);
		builder.append(", reportBody=");
		builder.append(reportBody);
		builder.append(", reportDate=");
		builder.append(reportDate);
		builder.append(", reportedBy=");
		builder.append(reportedByUser);
		builder.append(", laborCost=");
		builder.append(laborCost);
		builder.append("]");
		return builder.toString();
	}


	
}
