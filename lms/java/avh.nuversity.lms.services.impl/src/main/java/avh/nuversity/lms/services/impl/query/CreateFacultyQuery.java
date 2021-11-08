package avh.nuversity.lms.services.impl.query;

public class CreateFacultyQuery {

	private String name;
	private String university;
	private boolean isInternal;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public boolean isInternal() {
		return isInternal;
	}
	public void setInternal(boolean isInternal) {
		this.isInternal = isInternal;
	}
}
