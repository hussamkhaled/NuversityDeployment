package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the major database table.
 * 
 */
@Entity
@Table(name="major")
@NamedQuery(name="AvhMajor.findAll", query="SELECT a FROM AvhMajor a")
public class AvhMajor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	private String certificate;

	@Column(name="credit_cost")
	private BigDecimal creditCost;

	@Column(name="credit_number")
	private Integer creditNumber;

	private String description;

	private BigDecimal myears;

	private String name;
	
	private String prequisets;

	@ManyToOne
	@JoinColumn(name="pgm")
	private AvhPgm pgmBean;

	public AvhMajor() {
	}
	
	public AvhPgm getPgmBean() {
		return pgmBean;
	}

	public void setPgmBean(AvhPgm pgmBean) {
		this.pgmBean = pgmBean;
	}

	

	

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public String getCertificate() {
		return this.certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public BigDecimal getCreditCost() {
		return this.creditCost;
	}

	public void setCreditCost(BigDecimal creditCost) {
		this.creditCost = creditCost;
	}

	public Integer getCreditNumber() {
		return this.creditNumber;
	}

	public void setCreditNumber(Integer creditNumber) {
		this.creditNumber = creditNumber;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getMyears() {
		return this.myears;
	}

	public void setMyears(BigDecimal myears) {
		this.myears = myears;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrequisets() {
		return this.prequisets;
	}

	public void setPrequisets(String prequisets) {
		this.prequisets = prequisets;
	}

}