package avh.nuversity.lms.services.impl;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import avh.nuversity.lms.model.AvhCourse;
import avh.nuversity.lms.model.AvhCourseComp;
import avh.nuversity.lms.model.AvhCourseOfferSchedule;
import avh.nuversity.lms.model.AvhCourseOffering;
import avh.nuversity.lms.model.AvhMajorCourse;

import avh.nuversity.lms.services.impl.query.CourseCompQuery;

import avh.nuversity.lms.services.impl.query.CreateCourseOfferingQuery;
import avh.nuversity.lms.services.impl.query.CreateCourseOfferingScheduleQuery;
import avh.nuversity.lms.services.impl.query.CreateCourseQuery;
import avh.nuversity.lms.services.impl.rep.AvhRep;
import avh.nuversity.lms.services.impl.response.CourseOfferInfoResponse;
import avh.nuversity.lms.services.impl.response.CourseOfferScheduleResponse;
import enums.CourseOfferStatus;

@Component
public class CourseControllerImpl {
	@Autowired
	private AvhRep rep;

	public AvhCourse createCourse(CreateCourseQuery fc) {
		AvhCourse cs = new AvhCourse();
		cs.setCredit(fc.getCredit());
		cs.setDescription(fc.getDescription());
		cs.setFacultyBean(rep.getFacultyRep().findByIid(fc.getFacultyId()));
		cs.setTeacher(rep.getTeacherRep().findByIid(fc.getCoordinator()));
		cs.setTitle(fc.getTitle());
		cs.setIid(fc.getId());
		rep.getCourseRep().save(cs);
		
		return cs;
	}

	
	public String CourseComp(CourseCompQuery fc) {
		AvhCourseComp ccom = new AvhCourseComp();
		ccom.setCourse(rep.getCourseRep().findByIid(fc.getCourse()));
		ccom.setCourseCmp(rep.getCourseRep().findByIid(fc.getCourseComp()));
		ccom.setCompType(fc.getCompType());
		ccom.setIid(UUID.randomUUID().toString());
		rep.getCourseCompRep().save(ccom);
		
		return ErrorCode.Success;
	}


	public String newCourseOffering(CreateCourseOfferingQuery fc) {
		AvhCourseOffering co = new AvhCourseOffering();
		co.setCampusBean(rep.getCampusRep().findByIid(fc.getCampus()));
		co.setCapacity(fc.getCapacity());
		co.setCourseBean(rep.getCourseRep().findByIid(fc.getCourse()));
		co.setEffectiveDate(fc.getEffectiveDate());
		co.setExpiryDat(fc.getExpiryDate());
		co.setIid(UUID.randomUUID().toString());
		co.setOsection(fc.getOsection());
		co.setOyear(fc.getOyear());
		co.setSemesterBean(rep.getSemesterRep().findByIid(fc.getSemester()));
		co.setStatus(CourseOfferStatus.OPEN.toString());
		co.setTeacherBean(rep.getTeacherRep().findByIid(fc.getTeacher()));
		co.setOfferGradeFormat(fc.getCourseOfferFormat());
//		AvhOfferGradeFormat fcs = new AvhOfferGradeFormat();
//		fcs = rep.getOfferGradeFormat().findById("FORMAT A");
		rep.getCourseOfferingRep().save(co);
		
		return ErrorCode.Success;
	}


	public CourseOfferInfoResponse getCourseOfferInfo(String cId) {
		CourseOfferInfoResponse response = new CourseOfferInfoResponse();
		AvhCourseOffering cof = rep.getCourseOfferingRep().findByIid(cId);
		
		response.setCourse(cof.getCourseBean().getTitle());
		response.setCredit(cof.getCourseBean().getCredit());
		response.setDescription(cof.getCourseBean().getDescription());
		
		return response;
		
	}


	public CourseOfferScheduleResponse getcourseOfferSchedule(String cId) {
		
		CourseOfferScheduleResponse response = new CourseOfferScheduleResponse();
		 
		 String monday = "";
		 String tuesday = "";
		 String wednesday = "";
		 String thursday = "";
		 String friday = "";
		 String saturday = "";
		 String sunday = "";
		List<AvhCourseOfferSchedule> lst = rep.getCourseOfferScheduleRep().findByOffer(cId);
		String id = "";
		 String offer = "";
		for (AvhCourseOfferSchedule cos : lst) {
			id=cos.getIid();
			offer = cos.getOffer();
			if(cos.getCday() == 1) {
				monday +=removeSeconds(cos.getFromTime()) +" to " + removeSeconds(cos.getToTime())+" ";
			}
			if(cos.getCday() == 2) {
				tuesday +=removeSeconds(cos.getFromTime()) +" to " + removeSeconds(cos.getToTime())+" ";
			}
			if(cos.getCday() == 3) {
				wednesday +=removeSeconds(cos.getFromTime()) +" to " + removeSeconds(cos.getToTime())+" ";
			}
			if(cos.getCday() == 4) {
				thursday +=removeSeconds(cos.getFromTime()) +" to " + removeSeconds(cos.getToTime())+" ";
			}
			if(cos.getCday() == 5) {
				friday +=removeSeconds(cos.getFromTime()) +" to " + removeSeconds(cos.getToTime())+" ";
			}
			if(cos.getCday() == 6) {
				saturday +=removeSeconds(cos.getFromTime()) +" to " + removeSeconds(cos.getToTime())+" ";
			}
			if(cos.getCday() == 7) {
				sunday +=removeSeconds(cos.getFromTime()) +" to " + removeSeconds(cos.getToTime())+" ";
			}
		}
		response.setId(id);
		response.setOffer(offer);
		response.setMonday(monday);
		response.setTuesday(tuesday);
		response.setWednesday(wednesday);
		response.setThursday(thursday);
		response.setFriday(friday);
		response.setSaturday(saturday);
		response.setSunday(sunday);
		
		return response;
		
//		return rep.getCourseOfferScheduleRep().findByOffer(cId);
	}
	
	private String removeSeconds(Time t1) {
		Date myDate = new Date(t1.getTime());
		DateFormat df = new SimpleDateFormat("HH:mm");
		
		return df.format(myDate);
	}


	public List<AvhCourse> courseByMajorAndType(String mid, String ctype) {
		List<AvhCourse> response = new ArrayList<AvhCourse>();
		List<AvhMajorCourse> lst = rep.getMajorCourseRep().findByMajorBean(rep.getMajorRep().findByIid(mid));
		
		for (AvhMajorCourse cs : lst) {
			if(cs.getCourseType().equals(ctype)) {
				response.add(cs.getCourseBean());
			}
		}
		
		return response;
	}


	public AvhCourse getCourseById(String id) {
		return rep.getCourseRep().findByIid(id);
	}


	public List<AvhCourseOffering> courseByCourseOffers(String std,String major,List<String> courses) {
		List<AvhCourseOffering> response = new ArrayList<AvhCourseOffering>();
		for (String cs : courses) {
			response.add(rep.getCourseOfferingRep().findByIid(cs));
		}
		return response;
	}


	public String newCourseOfferingSchedule(CreateCourseOfferingScheduleQuery fc) {
		AvhCourseOfferSchedule sc = new AvhCourseOfferSchedule();
		sc.setIid(UUID.randomUUID().toString());
		sc.setOffer(fc.getOffer());
		sc.setCday(fc.getDay());
		sc.setFromTime(fc.getStartTime());
		sc.setToTime(fc.getEndTime());
		
		rep.getCourseOfferScheduleRep().save(sc);
		
		return ErrorCode.Success;
	}
}
