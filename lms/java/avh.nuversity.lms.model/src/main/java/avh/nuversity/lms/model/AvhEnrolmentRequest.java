package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDate;


/**
 * The persistent class for the enrolment_request database table.
 * 
 */
@Entity
@Table(name="enrolment_request")
@NamedQuery(name="AvhEnrolmentRequest.findAll", query="SELECT a FROM AvhEnrolmentRequest a")
public class AvhEnrolmentRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	private String reason;

	@Column(name="request_date")
	private LocalDate requestDate;

	private String status;

	//uni-directional many-to-one association to AvhCourseOffering
	@ManyToOne
	@JoinColumn(name="offer")
	private AvhCourseOffering courseOffering;

	//uni-directional many-to-one association to AvhStudent
	@ManyToOne
	@JoinColumn(name="student")
	private AvhStudent studentBean;

	public AvhEnrolmentRequest() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public LocalDate getRequestDate() {
		return this.requestDate;
	}

	public void setRequestDate(LocalDate localDate) {
		this.requestDate = localDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public AvhCourseOffering getCourseOffering() {
		return this.courseOffering;
	}

	public void setCourseOffering(AvhCourseOffering courseOffering) {
		this.courseOffering = courseOffering;
	}

	public AvhStudent getStudentBean() {
		return this.studentBean;
	}

	public void setStudentBean(AvhStudent studentBean) {
		this.studentBean = studentBean;
	}

}