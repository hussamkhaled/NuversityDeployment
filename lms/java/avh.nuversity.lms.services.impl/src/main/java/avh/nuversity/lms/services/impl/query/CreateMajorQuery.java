package avh.nuversity.lms.services.impl.query;

import java.math.BigDecimal;

public class CreateMajorQuery {

	private String name;
	private String program;
	private BigDecimal crd_cost;
	private int crdNumber;
	private BigDecimal myears;
	private String description;
	private String prerequisets;
	private String certificate;
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public int getCrdNumber() {
		return crdNumber;
	}
	public void setCrdNumber(int crdNumber) {
		this.crdNumber = crdNumber;
	}
	public BigDecimal getMyears() {
		return myears;
	}
	public void setMyears(BigDecimal myears) {
		this.myears = myears;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrerequ() {
		return prerequisets;
	}
	public void setPrerequ(String prerequ) {
		this.prerequisets = prerequ;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public BigDecimal getCrd_cost() {
		return crd_cost;
	}
	public void setCrd_cost(BigDecimal crd_cost) {
		this.crd_cost = crd_cost;
	}
}
