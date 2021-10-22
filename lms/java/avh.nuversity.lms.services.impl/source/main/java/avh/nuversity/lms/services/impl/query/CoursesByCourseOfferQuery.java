package avh.nuversity.lms.services.impl.query;

import java.util.List;

public class CoursesByCourseOfferQuery {

	private String studentId;
	private String major;
	private String[] courses;
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String[] getCourses() {
		return courses;
	}
	public void setCourses(String[] courses) {
		this.courses = courses;
	}
}
