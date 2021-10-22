package avh.nuversity.digid.services.impl.query;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

public class CreateTeacherQuery {
private String domain;
	
	private String group;
	
	
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

	private MultipartFile photo;

	private String primarylanguage;

	private String title;
	
	private String iddocument;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
	
	private MultipartFile idimage;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob2) {
		this.dob = dob2;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLandline() {
		return landline;
	}

	public void setLandline(String landline) {
		this.landline = landline;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMaritalstatus() {
		return maritalstatus;
	}

	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public String getPrimarylanguage() {
		return primarylanguage;
	}

	public void setPrimarylanguage(String primarylanguage) {
		this.primarylanguage = primarylanguage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIddocument() {
		return iddocument;
	}

	public void setIddocument(String iddocument) {
		this.iddocument = iddocument;
	}

	public MultipartFile getIdimage() {
		return idimage;
	}

	public void setIdimage(MultipartFile idimage) {
		this.idimage = idimage;
	}
	
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain2) {
		this.domain = domain2;
	}
	public String getGroup() {
		return this.group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
}
