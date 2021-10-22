package avh.nuversity.digid.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usergroups database table.
 * 
 */
@Entity
@Table(name="usergroups")
@NamedQuery(name="AvhUsergroup.findAll", query="SELECT a FROM AvhUsergroup a")
public class AvhUsergroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String eid;

	//uni-directional many-to-one association to AvhUser
	@ManyToOne
	@JoinColumn(name="usrid")
	private AvhUser auser;

	//uni-directional many-to-one association to AvhGroup
	@ManyToOne
	@JoinColumn(name="grpid")
	private AvhGroup egroup;

	public AvhUsergroup() {
	}

	public String getEid() {
		return this.eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public AvhUser getAuser() {
		return this.auser;
	}

	public void setAuser(AvhUser auser) {
		this.auser = auser;
	}

	public AvhGroup getEgroup() {
		return this.egroup;
	}

	public void setEgroup(AvhGroup egroup) {
		this.egroup = egroup;
	}

}