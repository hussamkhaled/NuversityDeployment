package avh.nuversity.lms.services.impl.response;

import java.time.LocalDate;
import java.util.List;

public class CurrentSemesterInfoResponse {

	private int year;
	private String semester;
	private LocalDate date;
	private List<CurrentSemesterCourseListResponse> courses;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public List<CurrentSemesterCourseListResponse> getCourses() {
		return courses;
	}
	public void setCourses(List<CurrentSemesterCourseListResponse> courses) {
		this.courses = courses;
	}
}
