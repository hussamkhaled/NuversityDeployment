package avh.nuversity.digid.services.impl.response;

public class ResetPasswordResponse {

	private String email;
	private ResetPasswordStatus status;
	private String userid;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public ResetPasswordResponse() {}
	public ResetPasswordResponse(String email, ResetPasswordStatus st) {
		this.email = email;
		this.status = st;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ResetPasswordStatus getStatus() {
		return status;
	}
	public void setStatus(ResetPasswordStatus status) {
		this.status = status;
	}
	
}
