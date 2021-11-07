package avh.nuversity.lms.services.impl.response;

import java.time.LocalDate;

public class StudentCheckAccountInfoResponse {

	private String major;
	private String userid;
	private String account;
	private String amount;
	private LocalDate asof;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public LocalDate getAsof() {
		return asof;
	}
	public void setAsof(LocalDate asof) {
		this.asof = asof;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
}
