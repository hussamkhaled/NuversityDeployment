package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the semester database table.
 * 
 */
@Entity
@Table(name="semester")
@NamedQuery(name="AvhSemester.findAll", query="SELECT a FROM AvhSemester a")
public class AvhSemester implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	private String label;

	public AvhSemester() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}