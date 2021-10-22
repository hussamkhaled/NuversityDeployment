package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the offer_grade_format database table.
 * 
 */
@Entity
@Table(name="offer_grade_format")
@NamedQuery(name="AvhOfferGradeFormat.findAll", query="SELECT a FROM AvhOfferGradeFormat a")
public class AvhOfferGradeFormat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	private String description;

	public AvhOfferGradeFormat() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}