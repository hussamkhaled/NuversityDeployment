package avh.nuversity.lms.services.impl.util;

import java.util.List;



public class ProgramRepresentation {

	private String program;
	private List<MajorRepresentation> lsMajor;
	
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public List<MajorRepresentation> getLsmajor() {
		return lsMajor;
	}
	public void setLsmajor(List<MajorRepresentation> lsmajor) {
		this.lsMajor = lsmajor;
	}
}
