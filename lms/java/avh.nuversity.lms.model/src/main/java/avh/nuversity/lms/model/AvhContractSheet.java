package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contract_sheet database table.
 * 
 */
@Entity
@Table(name="contract_sheet")
@NamedQuery(name="AvhContractSheet.findAll", query="SELECT a FROM AvhContractSheet a")
public class AvhContractSheet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	@Column(name="core_credit")
	private Integer coreCredit;

	@Column(name="elective_credit")
	private Integer electiveCredit;

	@Column(name="general_credit")
	private Integer generalCredit;

	@Column(name="major_credit")
	private Integer majorCredit;

	//uni-directional many-to-one association to AvhMajor
	@ManyToOne
	@JoinColumn(name="major")
	private AvhMajor majorBean;

	public AvhContractSheet() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public Integer getCoreCredit() {
		return this.coreCredit;
	}

	public void setCoreCredit(Integer coreCredit) {
		this.coreCredit = coreCredit;
	}

	public Integer getElectiveCredit() {
		return this.electiveCredit;
	}

	public void setElectiveCredit(Integer electiveCredit) {
		this.electiveCredit = electiveCredit;
	}

	public Integer getGeneralCredit() {
		return this.generalCredit;
	}

	public void setGeneralCredit(Integer generalCredit) {
		this.generalCredit = generalCredit;
	}

	public Integer getMajorCredit() {
		return this.majorCredit;
	}

	public void setMajorCredit(Integer majorCredit) {
		this.majorCredit = majorCredit;
	}

	public AvhMajor getMajorBean() {
		return this.majorBean;
	}

	public void setMajorBean(AvhMajor majorBean) {
		this.majorBean = majorBean;
	}

}