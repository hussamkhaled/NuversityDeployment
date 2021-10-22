package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the university database table.
 * 
 */
@Entity
@Table(name="university")
@NamedQuery(name="AvhUniversity.findAll", query="SELECT a FROM AvhUniversity a")
public class AvhUniversity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	private String name;

	public AvhUniversity() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}