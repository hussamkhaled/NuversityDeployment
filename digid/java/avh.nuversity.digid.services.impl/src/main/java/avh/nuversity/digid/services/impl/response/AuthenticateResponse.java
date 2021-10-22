package avh.nuversity.digid.services.impl.response;

import enums.GroupType;

public class AuthenticateResponse {
	private String email;
	private LoginStatus status;
	private String group;
	private String userId;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public AuthenticateResponse() {}
	public AuthenticateResponse(String email, LoginStatus st ,String grp) {
		this.email = email;
		this.status = st;
		this.group = grp;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String grptype) {
		this.group = grptype;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LoginStatus getStatus() {
		return status;
	}
	public void setStatus(LoginStatus status) {
		this.status = status;
	}
}
