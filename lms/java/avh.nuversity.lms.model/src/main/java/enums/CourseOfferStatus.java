package enums;

public enum CourseOfferStatus {

	OPEN("OPEN"),
	CLOSED("CLOSED"),
	CONFIRMED("CONFIRMED"),
	OVERBOOKED("OVERBOOKED"),
	CANCELED("CANCELED");
	
	private String label;
	
	private CourseOfferStatus(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return this.label;
	}
}
