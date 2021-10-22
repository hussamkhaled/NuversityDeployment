package avh.nuversity.digid.services.impl.response;

public class CreateTeacherResponse {
	private String email;
	private CreateContactStatus status;
	private String userId;
	private String numail;
	
	
	public String getNumail() {
		return numail;
	}

	public void setNumail(String numail) {
		this.numail = numail;
	}

	public CreateTeacherResponse() {}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public CreateContactStatus getStatus() {
		return status;
	}
	public void setStatus(CreateContactStatus status) {
		this.status = status;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
