package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pgm database table.
 * 
 */
@Entity
@Table(name="pgm")
@NamedQuery(name="AvhPgm.findAll", query="SELECT a FROM AvhPgm a")
public class AvhPgm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	private String name;

	//uni-directional many-to-one association to AvhDepartment
	@ManyToOne
	@JoinColumn(name="department")
	private AvhDepartment departmentBean;

	public AvhPgm() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AvhDepartment getDepartmentBean() {
		return this.departmentBean;
	}

	public void setDepartmentBean(AvhDepartment departmentBean) {
		this.departmentBean = departmentBean;
	}

}