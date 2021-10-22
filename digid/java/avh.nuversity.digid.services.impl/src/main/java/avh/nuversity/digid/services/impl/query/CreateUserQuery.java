package avh.nuversity.digid.services.impl.query;

import enums.DomainType;
import enums.GroupType;

//import avh.nuversity.digid.model.enums.DomainType;
//import avh.nuversity.digid.model.enums.GroupType;

public class CreateUserQuery {
	private String contactId;
	private String domain;
	private String group;
	private String password;
	
	public CreateUserQuery() {}
	public CreateUserQuery(String contactId, String domain) {
		this.contactId = contactId;
		this.domain = domain;
	}
	public String getContactId() {
		return contactId;
	}
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String string) {
		this.domain = string;
	}
	public String getGroup() {
		return this.group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
