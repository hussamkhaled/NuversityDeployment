package avh.nuversity.lms.services.impl.query;

import java.util.List;

public class RegisterCoursesQuery {

	private List<String> courses;
	private String studentId;
	private String majorId;
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getMajorId() {
		return majorId;
	}
	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}
	
}
