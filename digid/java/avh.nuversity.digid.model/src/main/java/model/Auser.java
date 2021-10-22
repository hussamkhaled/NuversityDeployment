package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the auser database table.
 * 
 */
@Entity
@NamedQuery(name="Auser.findAll", query="SELECT a FROM Auser a")
public class Auser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String userid;

	private String domainid;

	@Column(name="joining_date")
	private Timestamp joiningDate;

	private String numail;

	//uni-directional many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name="contactid")
	private Contact contact;

	//bi-directional many-to-one association to Usergroup
	@OneToMany(mappedBy="auser")
	private List<Usergroup> usergroups;

	public Auser() {
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

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public List<Usergroup> getUsergroups() {
		return this.usergroups;
	}

	public void setUsergroups(List<Usergroup> usergroups) {
		this.usergroups = usergroups;
	}

	public Usergroup addUsergroup(Usergroup usergroup) {
		getUsergroups().add(usergroup);
		usergroup.setAuser(this);

		return usergroup;
	}

	public Usergroup removeUsergroup(Usergroup usergroup) {
		getUsergroups().remove(usergroup);
		usergroup.setAuser(null);

		return usergroup;
	}

}