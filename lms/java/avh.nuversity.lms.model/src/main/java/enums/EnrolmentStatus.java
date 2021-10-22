package enums;

public enum EnrolmentStatus {

	PENDING("PENDING"),
	ACCEPTED("ACCEPTED"),
	REJECTED("REJECTED"),
	PASSED("PASSED"),
	FAILED("FAILED"),
	CANCELED("CANCELED"),
	DROPED("DROPED");
	
	private String label;
	
	private EnrolmentStatus(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return this.label;
	}
}
