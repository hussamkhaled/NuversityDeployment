package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the faculty database table.
 * 
 */
@Entity
@Table(name="faculty")
@NamedQuery(name="AvhFaculty.findAll", query="SELECT a FROM AvhFaculty a")
public class AvhFaculty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	@Column(name="is_internal")
	private Boolean isInternal;

	private String name;

	//uni-directional many-to-one association to AvhUniversity
	@ManyToOne
	@JoinColumn(name="university")
	private AvhUniversity universityBean;

	public AvhFaculty() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public Boolean getIsInternal() {
		return this.isInternal;
	}

	public void setIsInternal(Boolean isInternal) {
		this.isInternal = isInternal;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AvhUniversity getUniversityBean() {
		return this.universityBean;
	}

	public void setUniversityBean(AvhUniversity universityBean) {
		this.universityBean = universityBean;
	}

}