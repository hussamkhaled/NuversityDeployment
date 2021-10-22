package enums;

public enum PrimaryLanguage {
	ARABIC("ARABIC"),
	ENGLISH("ENGLISH"),
	FRENCH("FRENCH");
	
	
	private String label;
	
	private PrimaryLanguage(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return this.label;
	}
}
