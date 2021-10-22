package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the egroup database table.
 * 
 */
@Entity
@NamedQuery(name="Egroup.findAll", query="SELECT e FROM Egroup e")
public class Egroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String gid;

	private String glabel;

	//bi-directional many-to-one association to Usergroup
	@OneToMany(mappedBy="egroup")
	private List<Usergroup> usergroups;

	public Egroup() {
	}

	public String getGid() {
		return this.gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getGlabel() {
		return this.glabel;
	}

	public void setGlabel(String glabel) {
		this.glabel = glabel;
	}

	public List<Usergroup> getUsergroups() {
		return this.usergroups;
	}

	public void setUsergroups(List<Usergroup> usergroups) {
		this.usergroups = usergroups;
	}

	public Usergroup addUsergroup(Usergroup usergroup) {
		getUsergroups().add(usergroup);
		usergroup.setEgroup(this);

		return usergroup;
	}

	public Usergroup removeUsergroup(Usergroup usergroup) {
		getUsergroups().remove(usergroup);
		usergroup.setEgroup(null);

		return usergroup;
	}

}