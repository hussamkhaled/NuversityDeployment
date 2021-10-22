package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the global_gpa database table.
 * 
 */
@Entity
@Table(name="global_gpa")
@NamedQuery(name="AvhGlobalGpa.findAll", query="SELECT a FROM AvhGlobalGpa a")
public class AvhGlobalGpa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	private BigDecimal gpa;

	private String studentmajorid;

	public AvhGlobalGpa() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public BigDecimal getGpa() {
		return this.gpa;
	}

	public void setGpa(BigDecimal gpa) {
		this.gpa = gpa;
	}

	public String getStudentmajorid() {
		return this.studentmajorid;
	}

	public void setStudentmajorid(String studentmajorid) {
		this.studentmajorid = studentmajorid;
	}

}