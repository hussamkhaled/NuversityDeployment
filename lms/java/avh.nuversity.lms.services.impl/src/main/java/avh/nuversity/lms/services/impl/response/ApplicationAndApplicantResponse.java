package avh.nuversity.lms.services.impl.response;

import java.util.List;

public class ApplicationAndApplicantResponse {

	private String applicant;
	private String application;
	List<String> majors;
	public String getApplicant() {
		return applicant;
	}
	public List<String> getMajors() {
		return majors;
	}
	public void setMajors(List<String> majors) {
		this.majors = majors;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
	}
}
