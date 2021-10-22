package enums;

public enum CourseType {

	CORE("AUSTRALIA"),
	MAJOR("LEBANON"),
	ELECTIVE("USA"),
	GENERAL("GENERAL");
	
	private String label;
	
	private CourseType(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return this.label;
	}
}
