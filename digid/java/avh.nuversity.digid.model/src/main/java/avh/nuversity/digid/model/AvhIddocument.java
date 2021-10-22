package avh.nuversity.digid.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the iddocument database table.
 * 
 */
@Entity
@Table(name="iddocument")
@NamedQuery(name="AvhIddocument.findAll", query="SELECT a FROM AvhIddocument a")
public class AvhIddocument implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String cid;

	private String idphoto;

	public AvhIddocument() {
	}

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getIdphoto() {
		return this.idphoto;
	}

	public void setIdphoto(String idphoto) {
		this.idphoto = idphoto;
	}

}