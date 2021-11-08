package avh.nuversity.lms.services.impl.query;

import java.time.LocalDate;

public class CreateCourseOfferingQuery {

	private String course;
	private String semester;
	private int oyear;
	private String teacher;
	private String campus;
	private String osection;
	private int capacity;
	private String status;
	private LocalDate effectiveDate;
	private LocalDate expiryDate;
	private String courseOfferFormat;
	

	public String getCourseOfferFormat() {
		return courseOfferFormat;
	}
	public void setCourseOfferFormat(String courseOfferFormat) {
		this.courseOfferFormat = courseOfferFormat;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public int getOyear() {
		return oyear;
	}
	public void setOyear(int oyear) {
		this.oyear = oyear;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public String getOsection() {
		return osection;
	}
	public void setOsection(String osection) {
		this.osection = osection;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
}
