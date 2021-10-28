package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;


/**
 * The persistent class for the course_offer_schedule database table.
 * 
 */
@Entity
@Table(name="course_offer_schedule")
@NamedQuery(name="AvhCourseOfferSchedule.findAll", query="SELECT a FROM AvhCourseOfferSchedule a")
public class AvhCourseOfferSchedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String iid;

	private Integer cday;

	@Column(name="from_time")
	private Time fromTime;

	private String offer;

	@Column(name="to_time")
	private Time toTime;

	public AvhCourseOfferSchedule() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public Integer getCday() {
		return this.cday;
	}

	public void setCday(Integer cday) {
		this.cday = cday;
	}

	public Time getFromTime() {
		return this.fromTime;
	}

	public void setFromTime(Time fromTime) {
		this.fromTime = fromTime;
	}

	public String getOffer() {
		return this.offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

	public Time getToTime() {
		return this.toTime;
	}

	public void setToTime(Time toTime) {
		this.toTime = toTime;
	}

}