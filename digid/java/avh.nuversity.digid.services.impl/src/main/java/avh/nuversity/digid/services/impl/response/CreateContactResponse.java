package avh.nuversity.digid.services.impl.response;

public class CreateContactResponse {
	private String email;
	private CreateContactStatus status;
	private String userId;
	
	
	public CreateContactResponse() {}
	public CreateContactResponse(String email, CreateContactStatus st,String userID) {
		this.email = email;
		this.status = st;
		this.userId = userID;
	}
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
