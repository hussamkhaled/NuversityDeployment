package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the department database table.
 * 
 */
@Entity
@Table(name="department")
@NamedQuery(name="AvhDepartment.findAll", query="SELECT a FROM AvhDepartment a")
public class AvhDepartment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	private String director;

	@ManyToOne
	@JoinColumn(name="faculty")
	private AvhFaculty facultyBean;

	private String name;

	public AvhDepartment() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	
	public AvhFaculty getFacultyBean() {
		return facultyBean;
	}

	public void setFacultyBean(AvhFaculty facultyBean) {
		this.facultyBean = facultyBean;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}