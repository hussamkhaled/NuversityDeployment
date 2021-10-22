package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the major_req_doc database table.
 * 
 */
@Entity
@Table(name="major_req_doc")
@NamedQuery(name="AvhMajorReqDoc.findAll", query="SELECT a FROM AvhMajorReqDoc a")
public class AvhMajorReqDoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	private String label;

	public String getMajorBean() {
		return majorBean;
	}

	public void setMajorBean(String majorBean) {
		this.majorBean = majorBean;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	@Column(name="major")
	private String majorBean;

	public AvhMajorReqDoc() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}




}