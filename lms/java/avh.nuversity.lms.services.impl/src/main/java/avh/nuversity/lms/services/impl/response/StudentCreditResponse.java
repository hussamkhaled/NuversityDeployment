package avh.nuversity.lms.services.impl.response;

public class StudentCreditResponse {

	private String studentId;
	private int passedCrd;
	private int remainingCrd;
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public int getPassedCrd() {
		return passedCrd;
	}
	public void setPassedCrd(int passedCrd) {
		this.passedCrd = passedCrd;
	}
	public int getRemainingCrd() {
		return remainingCrd;
	}
	public void setRemainingCrd(int remainingCrd) {
		this.remainingCrd = remainingCrd;
	}
}
