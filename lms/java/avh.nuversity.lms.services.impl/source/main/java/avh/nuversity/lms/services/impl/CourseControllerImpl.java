package avh.nuversity.lms.services.impl;

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
import avh.nuversity.lms.model.AvhOfferGradeFormat;
import avh.nuversity.lms.services.impl.query.CourseCompQuery;
import avh.nuversity.lms.services.impl.query.CoursesByCourseOfferQuery;
import avh.nuversity.lms.services.impl.query.CreateCourseOfferingQuery;
import avh.nuversity.lms.services.impl.query.CreateCourseQuery;
import avh.nuversity.lms.services.impl.rep.AvhRep;
import avh.nuversity.lms.services.impl.response.CourseOfferInfoResponse;
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
		
		AvhCourseOfferSchedule schedule = new AvhCourseOfferSchedule();
		schedule.setIid(UUID.randomUUID().toString());
		schedule.setOffer(co.getIid());
		schedule.setMonday(fc.getMonday());
		schedule.setTuesday(fc.getTuesday());
		schedule.setWednesday(fc.getWednesday());
		schedule.setThursday(fc.getThursday());
		schedule.setFriday(fc.getFriday());
		schedule.setSaturday(fc.getSaturday());
		schedule.setSunday(fc.getSunday());
		rep.getCourseOfferScheduleRep().save(schedule);
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


	public AvhCourseOfferSchedule getcourseOfferSchedule(String cId) {
		return rep.getCourseOfferScheduleRep().findByOffer(cId);
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
}
