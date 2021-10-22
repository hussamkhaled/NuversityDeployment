package avh.nuversity.digid.services.impl.response;

public class PendingRequestResponse {
	private String email;
	private PendingRequestStatus status;
	
	
	public PendingRequestResponse() {}
	public PendingRequestResponse(String email, PendingRequestStatus st) {
		this.email = email;
		this.status = st;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public PendingRequestStatus getStatus() {
		return status;
	}
	public void setStatus(PendingRequestStatus status) {
		this.status = status;
	}
	
}
