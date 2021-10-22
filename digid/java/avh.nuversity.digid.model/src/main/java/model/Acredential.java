package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the acredentials database table.
 * 
 */
@Entity
@Table(name="acredentials")
@NamedQuery(name="Acredential.findAll", query="SELECT a FROM Acredential a")
public class Acredential implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cred_id")
	private String credId;

	private Boolean blocked;

	private String cmethod;

	@Column(name="expire_by")
	private Timestamp expireBy;

	private String loginid;

	private String pwddata;

	@Column(name="try_count")
	private Integer tryCount;

	public Acredential() {
	}

	public String getCredId() {
		return this.credId;
	}

	public void setCredId(String credId) {
		this.credId = credId;
	}

	public Boolean getBlocked() {
		return this.blocked;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}

	public String getCmethod() {
		return this.cmethod;
	}

	public void setCmethod(String cmethod) {
		this.cmethod = cmethod;
	}

	public Timestamp getExpireBy() {
		return this.expireBy;
	}

	public void setExpireBy(Timestamp expireBy) {
		this.expireBy = expireBy;
	}

	public String getLoginid() {
		return this.loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getPwddata() {
		return this.pwddata;
	}

	public void setPwddata(String pwddata) {
		this.pwddata = pwddata;
	}

	public Integer getTryCount() {
		return this.tryCount;
	}

	public void setTryCount(Integer tryCount) {
		this.tryCount = tryCount;
	}

}