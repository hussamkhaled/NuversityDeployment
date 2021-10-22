package avh.nuversity.digid.model;

import java.io.Serializable;
import javax.persistence.*;



import java.time.LocalDateTime;


/**
 * The persistent class for the apendingrequest database table.
 * 
 */
@Entity
@Table(name="apendingrequest")
@NamedQuery(name="AvhPendingRequest.findAll", query="SELECT a FROM AvhPendingRequest a")
public class AvhPendingRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String rlink;

	private LocalDateTime expirydate;

	private LocalDateTime issuedate;

	private String rstatus;

	private String rtype;

	private String usrid;

	public AvhPendingRequest() {
	}

	public String getRlink() {
		return this.rlink;
	}

	public void setRlink(String rlink) {
		this.rlink = rlink;
	}

	public LocalDateTime getExpirydate() {
		return this.expirydate;
	}

	public void setExpirydate(LocalDateTime edate) {
		this.expirydate = edate;
	}

	public LocalDateTime getIssuedate() {
		return this.issuedate;
	}

	public void setIssuedate(LocalDateTime idate) {
		this.issuedate = idate;
	}

	public String getRstatus() {
		return this.rstatus;
	}

	public void setRstatus(String pending) {
		this.rstatus = pending;
	}

	public String getRtype() {
		return this.rtype;
	}

	public void setRtype(String updatePassword) {
		this.rtype = updatePassword;
	}

	public String getUsrid() {
		return this.usrid;
	}

	public void setUsrid(String usrid) {
		this.usrid = usrid;
	}

}