package enums;

public enum CitizenShip {
	AUSTRALIA("AUSTRALIA"),
	LEBANON("LEBANON"),
	USA("USA");
	
	private String label;
	
	private CitizenShip(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return this.label;
	}
}
