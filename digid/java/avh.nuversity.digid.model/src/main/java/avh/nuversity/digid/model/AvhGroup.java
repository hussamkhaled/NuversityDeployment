package avh.nuversity.digid.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the egroup database table.
 * 
 */
@Entity
@Table(name="egroup")
@NamedQuery(name="AvhGroup.findAll", query="SELECT a FROM AvhGroup a")
public class AvhGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String gid;

	private String glabel;

	public AvhGroup() {
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

}