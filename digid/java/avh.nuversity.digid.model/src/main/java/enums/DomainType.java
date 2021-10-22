package enums;

public enum DomainType {
	NUVERSITY("NUVERSITY");
	
	private String label;
	
	private DomainType(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return this.label;
	}

}
