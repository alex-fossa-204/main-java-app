package by.andersen.intensive.yellow.team.entity.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ReportDTO implements Serializable{
	
	private static final long serialVersionUID = -142110737104972685L;

	private String reportTitle;
	
	private String reportBody;
	
	private Date reportDate;
	
	private int laborCost;

	public ReportDTO(String reportTitle, String reportBody, Date reportDate, int laborCost) {
		super();
		this.reportTitle = reportTitle;
		this.reportBody = reportBody;
		this.reportDate = reportDate;
		this.laborCost = laborCost;
	}

	public ReportDTO() {
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

	public int getLaborCost() {
		return laborCost;
	}

	public void setLaborCost(int laborCost) {
		this.laborCost = laborCost;
	}

	@Override
	public int hashCode() {
		return Objects.hash(laborCost, reportBody, reportDate, reportTitle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReportDTO other = (ReportDTO) obj;
		return laborCost == other.laborCost && Objects.equals(reportBody, other.reportBody)
				&& Objects.equals(reportDate, other.reportDate) && Objects.equals(reportTitle, other.reportTitle);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReportDTO [reportTitle=");
		builder.append(reportTitle);
		builder.append(", reportBody=");
		builder.append(reportBody);
		builder.append(", reportDate=");
		builder.append(reportDate);
		builder.append(", laborCost=");
		builder.append(laborCost);
		builder.append("]");
		return builder.toString();
	}
	
}





