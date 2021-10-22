package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the financial_document database table.
 * 
 */
@Entity
@Table(name="financial_document")
@NamedQuery(name="AvhFinancialDocument.findAll", query="SELECT a FROM AvhFinancialDocument a")
public class AvhFinancialDocument implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	private BigDecimal docref;

	//uni-directional many-to-one association to AvhFinancialOperation
	@ManyToOne
	@JoinColumn(name="operation")
	private AvhFinancialOperation financialOperation;

	public AvhFinancialDocument() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public BigDecimal getDocref() {
		return this.docref;
	}

	public void setDocref(BigDecimal docref) {
		this.docref = docref;
	}

	public AvhFinancialOperation getFinancialOperation() {
		return this.financialOperation;
	}

	public void setFinancialOperation(AvhFinancialOperation financialOperation) {
		this.financialOperation = financialOperation;
	}

}