package avh.nuversity.lms.model;

import java.io.Serializable;
import javax.persistence.*;


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

	private String friday;

	private String monday;

	private String offer;

	private String saturday;

	private String sunday;

	private String thursday;

	private String tuesday;

	private String wednesday;

	public AvhCourseOfferSchedule() {
	}

	public String getIid() {
		return this.iid;
	}

	public void setIid(String iid) {
		this.iid = iid;
	}

	public String getFriday() {
		return this.friday;
	}

	public void setFriday(String friday) {
		this.friday = friday;
	}

	public String getMonday() {
		return this.monday;
	}

	public void setMonday(String monday) {
		this.monday = monday;
	}

	public String getOffer() {
		return this.offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

	public String getSaturday() {
		return this.saturday;
	}

	public void setSaturday(String saturday) {
		this.saturday = saturday;
	}

	public String getSunday() {
		return this.sunday;
	}

	public void setSunday(String sunday) {
		this.sunday = sunday;
	}

	public String getThursday() {
		return this.thursday;
	}

	public void setThursday(String thursday) {
		this.thursday = thursday;
	}

	public String getTuesday() {
		return this.tuesday;
	}

	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}

	public String getWednesday() {
		return this.wednesday;
	}

	public void setWednesday(String wednesday) {
		this.wednesday = wednesday;
	}

}