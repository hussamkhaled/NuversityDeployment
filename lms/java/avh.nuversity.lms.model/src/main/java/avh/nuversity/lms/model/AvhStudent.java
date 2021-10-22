package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@Table(name="student")
@NamedQuery(name="AvhStudent.findAll", query="SELECT a FROM AvhStudent a")
public class AvhStudent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	private String campus;

	private String university;

	private String userid;

	public AvhStudent() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public String getCampus() {
		return this.campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getUniversity() {
		return this.university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}