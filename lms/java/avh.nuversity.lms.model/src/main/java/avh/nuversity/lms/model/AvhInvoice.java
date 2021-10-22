package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the invoice database table.
 * 
 */
@Entity
@Table(name="invoice")
@NamedQuery(name="AvhInvoice.findAll", query="SELECT a FROM AvhInvoice a")
public class AvhInvoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	private BigDecimal amount;

	private String comments;

	private String currency;

	@Column(name="due_date")
	private Timestamp dueDate;

	private Timestamp idate;

	private String subscription;

	private String userid;

	public AvhInvoice() {
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

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Timestamp getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}

	public Timestamp getIdate() {
		return this.idate;
	}

	public void setIdate(Timestamp idate) {
		this.idate = idate;
	}

	public String getSubscription() {
		return this.subscription;
	}

	public void setSubscription(String subscription) {
		this.subscription = subscription;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}