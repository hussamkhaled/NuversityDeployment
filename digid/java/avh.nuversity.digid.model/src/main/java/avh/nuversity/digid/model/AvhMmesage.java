package avh.nuversity.digid.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mmesage database table.
 * 
 */
@Entity
@Table(name="mmesage")
@NamedQuery(name="AvhMmesage.findAll", query="SELECT a FROM AvhMmesage a")
public class AvhMmesage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="msg_body")
	private String msgBody;

	@Column(name="msg_subject")
	private String msgSubject;
	
	@Id
	private String uid;

	public AvhMmesage() {
	}

	public String getMsgBody() {
		return this.msgBody;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}

	public String getMsgSubject() {
		return this.msgSubject;
	}

	public void setMsgSubject(String msgSubject) {
		this.msgSubject = msgSubject;
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}