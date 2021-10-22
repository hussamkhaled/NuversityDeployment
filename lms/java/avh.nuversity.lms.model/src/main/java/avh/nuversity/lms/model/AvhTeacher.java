package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the teacher database table.
 * 
 */
@Entity
@Table(name="teacher")
@NamedQuery(name="AvhTeacher.findAll", query="SELECT a FROM AvhTeacher a")
public class AvhTeacher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	private String university;

	private String userid;

	public AvhTeacher() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
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