package enums;

public enum GroupType {
	APPLICANT("APPLICANT"),
	STUDENT("STUDENT"),
	TEACHER("TEACHER"),
	DEAN("DEAN"),
	COORDINATOR("COORDINATOR"),
	MGMT("MGMT"),
	ADMIN("ADMIN");
	
	private String label;
	private GroupType(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return this.label;
	}
}
