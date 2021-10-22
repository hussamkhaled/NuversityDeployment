package enums;

public enum CourseComp {

	PREREQUISITES("PRE REQUISITES"),
	COREQUISITES("CO REQUISITES"),
	INCOMPATIBLE("INCOMPATIBLE");
	
	
	private String label;
	
	private CourseComp(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return this.label;
	}
}
