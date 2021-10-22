package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the app_docs database table.
 * 
 */
@Entity
@Table(name="app_docs")
@NamedQuery(name="AvhAppDoc.findAll", query="SELECT a FROM AvhAppDoc a")
public class AvhAppDoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	private String dlabel;

	@Column(name="doc_path")
	private String docPath;

	//uni-directional many-to-one association to AvhApplication
	@ManyToOne
	@JoinColumn(name="application_id")
	private AvhApplication application;

	public AvhAppDoc() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public String getDlabel() {
		return this.dlabel;
	}

	public void setDlabel(String dlabel) {
		this.dlabel = dlabel;
	}

	public String getDocPath() {
		return this.docPath;
	}

	public void setDocPath(String docPath) {
		this.docPath = docPath;
	}

	public AvhApplication getApplication() {
		return this.application;
	}

	public void setApplication(AvhApplication application) {
		this.application = application;
	}

}