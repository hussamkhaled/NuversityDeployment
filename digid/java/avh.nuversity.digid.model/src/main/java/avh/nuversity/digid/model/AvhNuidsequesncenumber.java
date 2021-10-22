package avh.nuversity.digid.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the nuidsequesncenumber database table.
 * 
 */
@Entity
@Table(name="nuidsequesncenumber")
@NamedQuery(name="AvhNuidsequesncenumber.findAll", query="SELECT a FROM AvhNuidsequesncenumber a")
public class AvhNuidsequesncenumber implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String groupe;

	private String nyear;

	private String squence;

	public AvhNuidsequesncenumber() {
	}

	public String getGroupe() {
		return this.groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}

	public String getNyear() {
		return this.nyear;
	}

	public void setNyear(String nyear) {
		this.nyear = nyear;
	}

	public String getSquence() {
		return this.squence;
	}

	public void setSquence(String squence) {
		this.squence = squence;
	}

}