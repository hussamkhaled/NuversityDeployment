package avh.nuversity.digid.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the auser database table.
 * 
 */
@Entity
@Table(name="auser")
@NamedQuery(name="AvhUser.findAll", query="SELECT a FROM AvhUser a")
public class AvhUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String userid;

	private String domainid;

	@Column(name="joining_date")
	private Timestamp joiningDate;

	private String numail;

	//uni-directional many-to-one association to AvhCredential
	@ManyToOne
	@JoinColumn(name="credential")
	private AvhCredentials acredential;

	//uni-directional many-to-one association to AvhContact
	@ManyToOne
	@JoinColumn(name="contactid")
	private AvhContact contact;

	public AvhUser() {
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getDomainid() {
		return this.domainid;
	}

	public void setDomainid(String domainid) {
		this.domainid = domainid;
	}

	public Timestamp getJoiningDate() {
		return this.joiningDate;
	}

	public void setJoiningDate(Timestamp joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getNumail() {
		return this.numail;
	}

	public void setNumail(String numail) {
		this.numail = numail;
	}

	public AvhCredentials getAcredential() {
		return this.acredential;
	}

	public void setAcredential(AvhCredentials acredential) {
		this.acredential = acredential;
	}

	public AvhContact getContact() {
		return this.contact;
	}

	public void setContact(AvhContact contact) {
		this.contact = contact;
	}

}