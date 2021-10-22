package avh.nuversity.lms.services.impl.util;

import java.util.List;

public class DepartmentRepresentation {

	private String department;
	private List<ProgramRepresentation> lsProgram;
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public List<ProgramRepresentation> getLsprogram() {
		return lsProgram;
	}
	public void setLsprogram(List<ProgramRepresentation> lsprogram) {
		this.lsProgram = lsprogram;
	}
}
