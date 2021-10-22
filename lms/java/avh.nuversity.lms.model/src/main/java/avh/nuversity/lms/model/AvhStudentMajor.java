package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the student_major database table.
 * 
 */
@Entity
@Table(name="student_major")
@NamedQuery(name="AvhStudentMajor.findAll", query="SELECT a FROM AvhStudentMajor a")
public class AvhStudentMajor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	private String majorid;

	//uni-directional many-to-one association to AvhStudent
	@ManyToOne
	@JoinColumn(name="studentid")
	private AvhStudent student;

	public AvhStudentMajor() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public String getMajorid() {
		return this.majorid;
	}

	public void setMajorid(String majorid) {
		this.majorid = majorid;
	}

	public AvhStudent getStudent() {
		return this.student;
	}

	public void setStudent(AvhStudent student) {
		this.student = student;
	}

}