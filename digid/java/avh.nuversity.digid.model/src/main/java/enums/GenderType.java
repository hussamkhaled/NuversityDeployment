package enums;

public enum GenderType {
	Male("Male"),
	Female("Female");
	
	private String label;
	
	private GenderType(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return this.label;
	}
}
