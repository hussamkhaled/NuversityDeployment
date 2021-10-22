package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the applicant database table.
 * 
 */
@Entity
@Table(name="applicant")
@NamedQuery(name="AvhApplicant.findAll", query="SELECT a FROM AvhApplicant a")
public class AvhApplicant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	private String userid;

	public AvhApplicant() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}