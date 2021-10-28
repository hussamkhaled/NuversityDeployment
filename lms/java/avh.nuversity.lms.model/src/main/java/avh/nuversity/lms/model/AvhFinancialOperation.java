package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

import java.time.LocalDate;


/**
 * The persistent class for the financial_operation database table.
 * 
 */
@Entity
@Table(name="financial_operation")
@NamedQuery(name="AvhFinancialOperation.findAll", query="SELECT a FROM AvhFinancialOperation a")
public class AvhFinancialOperation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	private BigDecimal amount;

	private String comments;

	private String msg;

	private LocalDate odate;

	private String otype;

	//uni-directional many-to-one association to AvhFinancialAccount
	@ManyToOne
	@JoinColumn(name="account")
	private AvhFinancialAccount financialAccount;

	public AvhFinancialOperation() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LocalDate getOdate() {
		return this.odate;
	}

	public void setOdate(LocalDate odate) {
		this.odate = odate;
	}

	public String getOtype() {
		return this.otype;
	}

	public void setOtype(String otype) {
		this.otype = otype;
	}

	public AvhFinancialAccount getFinancialAccount() {
		return this.financialAccount;
	}

	public void setFinancialAccount(AvhFinancialAccount financialAccount) {
		this.financialAccount = financialAccount;
	}

}