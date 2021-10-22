package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;


/**
 * The persistent class for the offer_session database table.
 * 
 */
@Entity
@Table(name="offer_session")
@NamedQuery(name="AvhOfferSession.findAll", query="SELECT a FROM AvhOfferSession a")
public class AvhOfferSession implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	@Column(name="end_time")
	private Time endTime;

	private Integer sday;

	@Column(name="start_time")
	private Time startTime;

	//uni-directional many-to-one association to AvhCourseOffering
	@ManyToOne
	@JoinColumn(name="offer")
	private AvhCourseOffering courseOffering;

	public AvhOfferSession() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public Time getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public Integer getSday() {
		return this.sday;
	}

	public void setSday(Integer sday) {
		this.sday = sday;
	}

	public Time getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public AvhCourseOffering getCourseOffering() {
		return this.courseOffering;
	}

	public void setCourseOffering(AvhCourseOffering courseOffering) {
		this.courseOffering = courseOffering;
	}

}