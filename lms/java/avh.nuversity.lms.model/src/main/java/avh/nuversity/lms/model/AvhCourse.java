package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@Table(name="course")
@NamedQuery(name="AvhCourse.findAll", query="SELECT a FROM AvhCourse a")
public class AvhCourse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	private Integer credit;

	private String description;

	private String title;

	//uni-directional many-to-one association to AvhFaculty
	@ManyToOne
	@JoinColumn(name="faculty")
	private AvhFaculty facultyBean;

	//uni-directional many-to-one association to AvhTeacher
	@ManyToOne
	@JoinColumn(name="coordinator")
	private AvhTeacher teacher;

	public AvhCourse() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public Integer getCredit() {
		return this.credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public AvhFaculty getFacultyBean() {
		return this.facultyBean;
	}

	public void setFacultyBean(AvhFaculty facultyBean) {
		this.facultyBean = facultyBean;
	}

	public AvhTeacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(AvhTeacher teacher) {
		this.teacher = teacher;
	}

}