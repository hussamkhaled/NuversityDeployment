package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the financial_account database table.
 * 
 */
@Entity
@Table(name="financial_account")
@NamedQuery(name="AvhFinancialAccount.findAll", query="SELECT a FROM AvhFinancialAccount a")
public class AvhFinancialAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	@Column(name="account_type")
	private String accountType;

	private double amount;

	private String currency;

	private String userid;

	public AvhFinancialAccount() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}