package enums;

public enum Currency {

	USD("USD"),
	LBP("LBP"),
	AUD("AUD");
	
	private String label;
	
	private Currency(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return this.label;
	}
}
