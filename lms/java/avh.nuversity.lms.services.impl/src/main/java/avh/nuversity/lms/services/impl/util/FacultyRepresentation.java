package avh.nuversity.lms.services.impl.util;

import java.util.List;



public class FacultyRepresentation {

	private String faculty;
	private List<DepartmentRepresentation> lsDepartment;
	
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public List<DepartmentRepresentation> getLsDepartment() {
		return lsDepartment;
	}
	public void setLsDepartment(List<DepartmentRepresentation> lsDepartment) {
		this.lsDepartment = lsDepartment;
	}
}
