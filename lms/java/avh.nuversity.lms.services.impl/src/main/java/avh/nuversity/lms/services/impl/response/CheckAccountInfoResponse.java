package avh.nuversity.lms.services.impl.response;


import java.time.LocalDate;
import java.util.List;

public class CheckAccountInfoResponse {

	
	private String account;
	private double amount;
	private LocalDate from;
	private LocalDate to;
	private LocalDate asof;
	private List<OperationResponse> operations;
	public List<OperationResponse> getOperations() {
		return operations;
	}
	public void setOperations(List<OperationResponse> operations) {
		this.operations = operations;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getFrom() {
		return from;
	}
	public void setFrom(LocalDate from) {
		this.from = from;
	}
	public LocalDate getTo() {
		return to;
	}
	public void setTo(LocalDate to) {
		this.to = to;
	}
	public LocalDate getAsof() {
		return asof;
	}
	public void setAsof(LocalDate asof) {
		this.asof = asof;
	}
}
