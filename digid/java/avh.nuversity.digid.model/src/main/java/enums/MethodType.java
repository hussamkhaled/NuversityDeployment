package enums;

public enum MethodType {
	Password("PASSWORD"),
	FaceId("FACE ID");
	
	private String label;
	
	private MethodType(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return this.label;
	}

}
