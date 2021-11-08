package avh.nuversity.lms.services.impl.response;

public class AllEnrolmentResponse {

	private String courseName;
	private String enrId;
	private String studentId;
	private String majorId;
	private String majorName;
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getEnrId() {
		return enrId;
	}
	public void setEnrId(String enrId) {
		this.enrId = enrId;
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
