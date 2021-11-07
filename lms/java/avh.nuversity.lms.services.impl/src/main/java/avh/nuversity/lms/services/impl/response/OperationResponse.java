package avh.nuversity.lms.services.impl.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OperationResponse {

	private LocalDate date;
	private String ref;
	private String crdr;
	private BigDecimal amount;
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getCrdr() {
		return crdr;
	}
	public void setCrdr(String crdr) {
		this.crdr = crdr;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
