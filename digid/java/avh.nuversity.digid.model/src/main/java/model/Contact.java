package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the contact database table.
 * 
 */
@Entity
@NamedQuery(name="Contact.findAll", query="SELECT c FROM Contact c")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	private String caddress;

	private String citizenship;

//	private String contactid;

	private Timestamp dob;

	private String firstname;

	private String gender;

	private String landline;

	private String lastname;

	private String maritalstatus;

	private String middlename;

	private String phone;

	private String photo;

	private String primarylanguage;

	private String title;

	public Contact() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCaddress() {
		return this.caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public String getCitizenship() {
		return this.citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

//	public String getContactid() {
//		return this.contactid;
//	}
//
//	public void setContactid(String contactid) {
//		this.contactid = contactid;
//	}

	public Timestamp getDob() {
		return this.dob;
	}

	public void setDob(Timestamp dob) {
		this.dob = dob;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLandline() {
		return this.landline;
	}

	public void setLandline(String landline) {
		this.landline = landline;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMaritalstatus() {
		return this.maritalstatus;
	}

	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	public String getMiddlename() {
		return this.middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPrimarylanguage() {
		return this.primarylanguage;
	}

	public void setPrimarylanguage(String primarylanguage) {
		this.primarylanguage = primarylanguage;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}