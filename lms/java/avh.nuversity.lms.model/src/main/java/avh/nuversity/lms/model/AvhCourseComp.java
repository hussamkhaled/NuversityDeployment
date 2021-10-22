package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the course_comp database table.
 * 
 */
@Entity
@Table(name="course_comp")
@NamedQuery(name="AvhCourseComp.findAll", query="SELECT a FROM AvhCourseComp a")
public class AvhCourseComp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	@Column(name="comp_type")
	private String compType;

	@ManyToOne
	@JoinColumn(name="course")
	private AvhCourse course;

	@ManyToOne
	@JoinColumn(name="course_cmp")
	private AvhCourse courseCmp;

	public AvhCourseComp() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public String getCompType() {
		return this.compType;
	}

	public void setCompType(String compType) {
		this.compType = compType;
	}

	public AvhCourse getCourse() {
		return course;
	}

	public void setCourse(AvhCourse course) {
		this.course = course;
	}

	public AvhCourse getCourseCmp() {
		return courseCmp;
	}

	public void setCourseCmp(AvhCourse courseCmp) {
		this.courseCmp = courseCmp;
	}


}