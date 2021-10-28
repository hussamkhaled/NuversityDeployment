package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDate;


/**
 * The persistent class for the course_offering database table.
 * 
 */
@Entity
@Table(name="course_offering")
@NamedQuery(name="AvhCourseOffering.findAll", query="SELECT a FROM AvhCourseOffering a")
public class AvhCourseOffering implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	@ManyToOne
	@JoinColumn(name="campus")
	private AvhCampus campusBean;

	private Integer capacity;
	
	@ManyToOne
	@JoinColumn(name="course")
	private AvhCourse courseBean;

	@Column(name="effective_date")
	private LocalDate effectiveDate;

	@Column(name="expiry_dat")
	private LocalDate expiryDat;

	private String osection;

	private Integer oyear;

	@ManyToOne
	@JoinColumn(name="semester")
	private AvhSemester semesterBean;

	private String status;

	@ManyToOne
	@JoinColumn(name="teacher")
	private AvhTeacher teacherBean;

	//uni-directional many-to-one association to AvhOfferGradeFormat
	
	@Column(name="grade_format")
	private String offerGradeFormat;

	public AvhCourseOffering() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	
	public Integer getCapacity() {
		return this.capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}



	public AvhCampus getCampusBean() {
		return campusBean;
	}

	public void setCampusBean(AvhCampus campusBean) {
		this.campusBean = campusBean;
	}

	public AvhCourse getCourseBean() {
		return courseBean;
	}

	public void setCourseBean(AvhCourse courseBean) {
		this.courseBean = courseBean;
	}

	public LocalDate getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public LocalDate getExpiryDat() {
		return this.expiryDat;
	}

	public void setExpiryDat(LocalDate expiryDat) {
		this.expiryDat = expiryDat;
	}

	public String getOsection() {
		return this.osection;
	}

	public void setOsection(String osection) {
		this.osection = osection;
	}

	public Integer getOyear() {
		return this.oyear;
	}

	public void setOyear(Integer oyear) {
		this.oyear = oyear;
	}

	

	public AvhSemester getSemesterBean() {
		return semesterBean;
	}

	public void setSemesterBean(AvhSemester semesterBean) {
		this.semesterBean = semesterBean;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public AvhTeacher getTeacherBean() {
		return teacherBean;
	}

	public void setTeacherBean(AvhTeacher teacherBean) {
		this.teacherBean = teacherBean;
	}

	public String getOfferGradeFormat() {
		return this.offerGradeFormat;
	}

	public void setOfferGradeFormat(String offerGradeFormat) {
		this.offerGradeFormat = offerGradeFormat;
	}

}