package avh.nuversity.lms.services.impl.query;

import java.time.LocalDate;

public class CheckAccountInfoQuery {

	private String userId;
	private String major;
	private LocalDate from;
	private LocalDate to;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
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
}
