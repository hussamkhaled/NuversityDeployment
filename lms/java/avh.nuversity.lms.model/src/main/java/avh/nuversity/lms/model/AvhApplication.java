package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;


/**
 * The persistent class for the application database table.
 * 
 */
@Entity
@Table(name="application")
@NamedQuery(name="AvhApplication.findAll", query="SELECT a FROM AvhApplication a")
public class AvhApplication implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	private LocalDate appdate;

	private String status;

	//uni-directional many-to-one association to AvhApplicant
	@ManyToOne
	@JoinColumn(name="applicant")
	private AvhApplicant applicantBean;

	//uni-directional many-to-one association to AvhMajor
	@ManyToOne
	@JoinColumn(name="major")
	private AvhMajor majorBean;

	public AvhApplication() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public LocalDate getAppdate() {
		return this.appdate;
	}

	public void setAppdate(LocalDate localDate) {
		this.appdate = localDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public AvhApplicant getApplicantBean() {
		return this.applicantBean;
	}

	public void setApplicantBean(AvhApplicant applicantBean) {
		this.applicantBean = applicantBean;
	}

	public AvhMajor getMajorBean() {
		return this.majorBean;
	}

	public void setMajorBean(AvhMajor majorBean) {
		this.majorBean = majorBean;
	}

}