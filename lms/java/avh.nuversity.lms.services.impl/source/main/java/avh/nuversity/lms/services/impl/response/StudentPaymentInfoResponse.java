package avh.nuversity.lms.services.impl.response;

import java.math.BigDecimal;

public class StudentPaymentInfoResponse {

	private String userid;
	private String major;
	private double amount;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
