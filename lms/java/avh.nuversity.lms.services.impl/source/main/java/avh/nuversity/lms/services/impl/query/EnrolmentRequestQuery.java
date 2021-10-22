package avh.nuversity.lms.services.impl.query;

import java.time.LocalDate;

public class EnrolmentRequestQuery {

	private String student;
	private String offer;
	private LocalDate reqDate;
	private String status;
	private String reason;
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	public String getOffer() {
		return offer;
	}
	public void setOffer(String offer) {
		this.offer = offer;
	}
	public LocalDate getReqDate() {
		return reqDate;
	}
	public void setReqDate(LocalDate reqDate) {
		this.reqDate = reqDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
