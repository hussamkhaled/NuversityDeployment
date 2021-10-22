package enums;

public enum ApplicationStatus {
	NEW("NEW"),
	ACCEPTED("ACCEPTED"),
	REJECTED("INCOMPATIBLE"),
	INPROGRESS("INPROGRESS"),
	PENDING("PENDING");
	
	
	private String label;
	
	private ApplicationStatus(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return this.label;
	}
}
