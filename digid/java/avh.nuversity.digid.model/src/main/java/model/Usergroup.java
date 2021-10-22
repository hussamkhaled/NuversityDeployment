package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usergroups database table.
 * 
 */
@Entity
@Table(name="usergroups")
@NamedQuery(name="Usergroup.findAll", query="SELECT u FROM Usergroup u")
public class Usergroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String eid;

	//bi-directional many-to-one association to Auser
	@ManyToOne
	@JoinColumn(name="usrid")
	private Auser auser;

	//bi-directional many-to-one association to Egroup
	@ManyToOne
	@JoinColumn(name="grpid")
	private Egroup egroup;

	public Usergroup() {
	}

	public String getEid() {
		return this.eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public Auser getAuser() {
		return this.auser;
	}

	public void setAuser(Auser auser) {
		this.auser = auser;
	}

	public Egroup getEgroup() {
		return this.egroup;
	}

	public void setEgroup(Egroup egroup) {
		this.egroup = egroup;
	}

}