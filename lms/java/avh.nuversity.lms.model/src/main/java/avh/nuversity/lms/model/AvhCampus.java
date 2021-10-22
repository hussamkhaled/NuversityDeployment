package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the campus database table.
 * 
 */
@Entity
@Table(name="campus")
@NamedQuery(name="AvhCampus.findAll", query="SELECT a FROM AvhCampus a")
public class AvhCampus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	private String caddress;

	private String name;

	private String phone;

	public AvhCampus() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public String getCaddress() {
		return this.caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}