package enums;

public enum PendingRequestStatus {

	CONFIRMED("CONFIRMED"),
	PENDING("PENDING"),
	EXPIRED("EXPIRED");
	
	private String label;
	
	private PendingRequestStatus(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return this.label;
	}
	
}
