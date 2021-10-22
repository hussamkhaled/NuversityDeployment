package enums;

public enum FDocType {

	Cash("Cash"),
	Online("Online"),
	Invoice("Invoice"),
	Discount("Discount");
	
	private String label;
	
	private FDocType(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return this.label;
	}
}
