package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the invoice_line database table.
 * 
 */
@Entity
@Table(name="invoice_line")
@NamedQuery(name="AvhInvoiceLine.findAll", query="SELECT a FROM AvhInvoiceLine a")
public class AvhInvoiceLine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	private BigDecimal amount;

	@Column(name="change_rate")
	private BigDecimal changeRate;

	private String description;

	//uni-directional many-to-one association to AvhCurrency
	
	@Column(name="currency")
	private String currencyBean;

	//uni-directional many-to-one association to AvhInvoice
	@ManyToOne
	@JoinColumn(name="invoice")
	private AvhInvoice invoiceBean;

	public AvhInvoiceLine() {
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

	public BigDecimal getChangeRate() {
		return this.changeRate;
	}

	public void setChangeRate(BigDecimal changeRate) {
		this.changeRate = changeRate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public String getCurrencyBean() {
		return currencyBean;
	}

	public void setCurrencyBean(String currencyBean) {
		this.currencyBean = currencyBean;
	}

	public AvhInvoice getInvoiceBean() {
		return this.invoiceBean;
	}

	public void setInvoiceBean(AvhInvoice invoiceBean) {
		this.invoiceBean = invoiceBean;
	}

}