package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the major_course database table.
 * 
 */
@Entity
@Table(name="major_course")
@NamedQuery(name="AvhMajorCourse.findAll", query="SELECT a FROM AvhMajorCourse a")
public class AvhMajorCourse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	@Column(name="course_type")
	private String courseType;

	//uni-directional many-to-one association to AvhCourse
	@ManyToOne
	@JoinColumn(name="course")
	private AvhCourse courseBean;

	//uni-directional many-to-one association to AvhMajor
	@ManyToOne
	@JoinColumn(name="major")
	private AvhMajor majorBean;

	public AvhMajorCourse() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public String getCourseType() {
		return this.courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public AvhCourse getCourseBean() {
		return this.courseBean;
	}

	public void setCourseBean(AvhCourse courseBean) {
		this.courseBean = courseBean;
	}

	public AvhMajor getMajorBean() {
		return this.majorBean;
	}

	public void setMajorBean(AvhMajor majorBean) {
		this.majorBean = majorBean;
	}

}