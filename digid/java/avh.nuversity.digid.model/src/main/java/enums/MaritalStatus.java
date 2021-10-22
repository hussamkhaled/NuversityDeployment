package enums;

public enum MaritalStatus {
	Married("Married"),
	Single("Single");
	
	
	private String label;
	
	private MaritalStatus(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return this.label;
	}
}
