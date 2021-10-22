package avh.nuversity.digid.model;

import java.io.Serializable;
import javax.persistence.*;




import java.time.LocalDate;


/**
 * The persistent class for the contact database table.
 * 
 */
@Entity
@Table(name="contact")
@NamedQuery(name="AvhContact.findAll", query="SELECT a FROM AvhContact a")
public class AvhContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	private String caddress;

	private String citizenship;

	private LocalDate dob;

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

	//uni-directional many-to-one association to AvhIddocument
	@ManyToOne
	@JoinColumn(name="iddocument")
	private AvhIddocument iddocumentBean;

	public AvhContact() {
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

	public void setCitizenship(String citizenShip2) {
		this.citizenship = citizenShip2;
	}

	public LocalDate getDob() {
		return this.dob;
	}

	public void setDob(LocalDate string) {
		this.dob = string;
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

	public void setGender(String genderType) {
		this.gender = genderType;
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

	public void setMaritalstatus(String maritalStatus2) {
		this.maritalstatus = maritalStatus2;
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

	public void setPrimarylanguage(String primaryLanguage2) {
		this.primarylanguage = primaryLanguage2;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String titleType) {
		this.title = titleType;
	}

	public AvhIddocument getIddocumentBean() {
		return this.iddocumentBean;
	}

	public void setIddocumentBean(AvhIddocument iddocumentBean) {
		this.iddocumentBean = iddocumentBean;
	}

}