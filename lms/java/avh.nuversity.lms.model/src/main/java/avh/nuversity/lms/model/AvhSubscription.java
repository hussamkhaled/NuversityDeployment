package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the subscription database table.
 * 
 */
@Entity
@Table(name="subscription")
@NamedQuery(name="AvhSubscription.findAll", query="SELECT a FROM AvhSubscription a")
public class AvhSubscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	private Integer oyear;

	//uni-directional many-to-one association to AvhSemester
	@ManyToOne
	@JoinColumn(name="semester")
	private AvhSemester semesterBean;

	//uni-directional many-to-one association to AvhStudent
	@ManyToOne
	@JoinColumn(name="student")
	private AvhStudent studentBean;

	public AvhSubscription() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public Integer getOyear() {
		return this.oyear;
	}

	public void setOyear(Integer oyear) {
		this.oyear = oyear;
	}

	public AvhSemester getSemesterBean() {
		return this.semesterBean;
	}

	public void setSemesterBean(AvhSemester semesterBean) {
		this.semesterBean = semesterBean;
	}

	public AvhStudent getStudentBean() {
		return this.studentBean;
	}

	public void setStudentBean(AvhStudent studentBean) {
		this.studentBean = studentBean;
	}

}