package enums;

public enum TitleType {
	Mr("Mr"),
	Mrs("Mrs"),
	Ms("Ms"),
	Dr("Dr");
	
	private String label;
	
	private TitleType(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return this.label;
	}

}
