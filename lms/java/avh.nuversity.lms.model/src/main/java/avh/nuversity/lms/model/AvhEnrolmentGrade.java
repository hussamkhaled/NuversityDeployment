package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the enrolment_grade database table.
 * 
 */
@Entity
@Table(name="enrolment_grade")
@NamedQuery(name="AvhEnrolmentGrade.findAll", query="SELECT a FROM AvhEnrolmentGrade a")
public class AvhEnrolmentGrade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	@Column(name="enrolment_request")
	private String enrolmentRequestBean;

	private int grade;

	@Column(name="offer_grade_line")
	private String offerGradeLine;

	public AvhEnrolmentGrade() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	

	public String getEnrolmentRequestBean() {
		return enrolmentRequestBean;
	}

	public void setEnrolmentRequestBean(String enrolmentRequestBean) {
		this.enrolmentRequestBean = enrolmentRequestBean;
	}

	public String getOfferGradeLine() {
		return offerGradeLine;
	}

	public void setOfferGradeLine(String offerGradeLine) {
		this.offerGradeLine = offerGradeLine;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	

	

}