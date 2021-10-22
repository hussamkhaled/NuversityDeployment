package avh.nuversity.lms.services.impl.query;

public class SubscribeStudentSemesterQuery {

	private String student;
	private String semester;
	private int oyear;
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
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
}
