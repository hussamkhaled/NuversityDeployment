package enums;

public enum FOperationType {

	CR("CR"),
	DR("DR");
	
	private String label;
	
	private FOperationType(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return this.label;
	}
}
