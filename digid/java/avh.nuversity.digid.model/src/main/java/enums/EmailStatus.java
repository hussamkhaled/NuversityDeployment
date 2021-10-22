package enums;

public enum EmailStatus {

	
		UPDATE_PASSWORD("UPDATE_PASSWORD"),
		INVITATION("INVITATION"),
	    SET_PASSWORD("SET_PASSWORD"),
	    MAKE_STUDENT("MAKE_STUDENT");
		
		private String label;
		
		private EmailStatus(String label) {
			this.label = label;
		}
		
		@Override
		public String toString() {
			return this.label;
		}
}
