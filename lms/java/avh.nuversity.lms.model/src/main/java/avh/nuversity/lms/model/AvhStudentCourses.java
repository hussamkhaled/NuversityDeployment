package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the student_courses database table.
 * 
 */
@Entity
@Table(name="student_courses")
@NamedQuery(name="AvhStudentCourses.findAll", query="SELECT a FROM AvhStudentCourses a")
public class AvhStudentCourses implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	private String courseo;

	private String status;

	private String studentmajorid;

	public AvhStudentCourses() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public String getCourseo() {
		return this.courseo;
	}

	public void setCourseo(String courseo) {
		this.courseo = courseo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStudentmajorid() {
		return this.studentmajorid;
	}

	public void setStudentmajorid(String studentmajorid) {
		this.studentmajorid = studentmajorid;
	}

}