package avh.nuversity.lms.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import avh.nuversity.lms.model.AvhCourse;
import avh.nuversity.lms.model.AvhCourseOfferSchedule;
import avh.nuversity.lms.model.AvhCourseOffering;
import avh.nuversity.lms.services.impl.CourseControllerImpl;
import avh.nuversity.lms.services.impl.query.CourseCompQuery;
import avh.nuversity.lms.services.impl.query.CoursesByCourseOfferQuery;
import avh.nuversity.lms.services.impl.query.CreateCourseOfferingQuery;
import avh.nuversity.lms.services.impl.query.CreateCourseQuery;
import avh.nuversity.lms.services.impl.response.CourseOfferInfoResponse;

@RestController
public class CourseController {

	@Autowired
	private CourseControllerImpl svc;
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/lms/course")
	public AvhCourse newCourse(@RequestBody CreateCourseQuery fc) {
		return svc.createCourse(fc);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/lms/courseComp")
	public String CourseComp(@RequestBody CourseCompQuery fc) {
		return svc.CourseComp(fc);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/lms/courseOffering")
	public String newCourseOffering(@RequestBody CreateCourseOfferingQuery fc) {
		return svc.newCourseOffering(fc);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/courseOfferInfo/{id}")
	public CourseOfferInfoResponse getCourseOfferInfo(@PathVariable("id") String cId) {
		return svc.getCourseOfferInfo(cId);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/courseOfferSchedule/{id}")
	public AvhCourseOfferSchedule getcourseOfferSchedule(@PathVariable("id") String cId) {
		return svc.getcourseOfferSchedule(cId);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/courseByMajorAndType/{majorid}/{ctype}")
	public List<AvhCourse> courseByMajorAndType(@PathVariable("majorid") String mid,@PathVariable("ctype") String ctype) {
		return svc.courseByMajorAndType(mid,ctype);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/courseById/{id}")
	public AvhCourse getCourseById(@PathVariable("id") String id) {
		return svc.getCourseById(id);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/courseByCourseOffers")
	public List<AvhCourseOffering> courseByCourseOffers(@PathVariable("studentId") String student,@PathVariable("major") String major,@PathVariable("courses") List<String> courses) {
		return svc.courseByCourseOffers(student,major,courses);
	}
	
	
}
