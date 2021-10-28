package avh.nuversity.lms.services.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import avh.nuversity.lms.model.AvhCampus;

import avh.nuversity.lms.model.AvhFinancialAccount;
import avh.nuversity.lms.model.AvhGlobalGpa;
import avh.nuversity.lms.model.AvhStudent;
import avh.nuversity.lms.services.impl.StudentControllerImpl;
import avh.nuversity.lms.services.impl.query.AcceptRegisterCoursesQuery;
import avh.nuversity.lms.services.impl.query.CheckAccountInfoQuery;
import avh.nuversity.lms.services.impl.query.CreateStudentQuery;
import avh.nuversity.lms.services.impl.query.DropCoursesQuery;
import avh.nuversity.lms.services.impl.query.EnrolmentRequestQuery;
import avh.nuversity.lms.services.impl.query.PaymentQuery;
import avh.nuversity.lms.services.impl.query.RegisterCoursesQuery;
import avh.nuversity.lms.services.impl.query.SubscribeStudentSemesterQuery;
import avh.nuversity.lms.services.impl.response.AllEnrolmentResponse;
import avh.nuversity.lms.services.impl.response.AllPendingStudentResponse;
import avh.nuversity.lms.services.impl.response.CheckAccountInfoResponse;
import avh.nuversity.lms.services.impl.response.CoursesOfferResponse;
import avh.nuversity.lms.services.impl.response.CurrentSemesterInfoResponse;
import avh.nuversity.lms.services.impl.response.DropCoursesResponse;
import avh.nuversity.lms.services.impl.response.RegisterCoursesResponse;
import avh.nuversity.lms.services.impl.response.StudentCalendarResponse;
import avh.nuversity.lms.services.impl.response.StudentCheckAccountInfoResponse;
import avh.nuversity.lms.services.impl.response.StudentContractSheet;
import avh.nuversity.lms.services.impl.response.StudentCourseHistoryResponse;
import avh.nuversity.lms.services.impl.response.StudentCreditResponse;
import avh.nuversity.lms.services.impl.response.StudentCurrentSemesterInfoResponse;
import avh.nuversity.lms.services.impl.response.StudentHistoryInfoResponse;
import avh.nuversity.lms.services.impl.response.StudentPaymentInfoResponse;

@RestController
public class StudentController {

	@Autowired
	private StudentControllerImpl svc;
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/student/{id}")
	public AvhStudent getStudent(@PathVariable("id") String cttId) {
		return svc.getStudent(cttId);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/lms/student")
	public AvhStudent newStudent(@RequestBody CreateStudentQuery fc) {
		return svc.createStudent(fc);
	}
	
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/allPendingStudent")
	public List<AllPendingStudentResponse> allPendingStudent() {
		return svc.allPendingStudent();
	}
	
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/lms/subscribeSemester")
	public String subscribeSemester(@RequestBody SubscribeStudentSemesterQuery fc) {
		return svc.subscribeSemester(fc);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/allSemester")
	public List<String> getAllSemester() {
		return svc.getAllSemester();
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/lms/enrolmentRequest")
	public String enrolmentRequest(@RequestBody EnrolmentRequestQuery fc) {
		return svc.enrolmentRequest(fc);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/studentCampus/{id}")
	public AvhCampus getStudentCampus(@PathVariable("id") String cttId) {
		return svc.getStudentCampus(cttId);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/studentGlobalGPA/{id}/{major}")
	public AvhGlobalGpa getStudentGlobalGPA(@PathVariable("id") String SId,@PathVariable("major") String mId) {
		return svc.getStudentGlobalGPA(SId,mId);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/studentCredit/{id}/{major}")
	public StudentCreditResponse getStudentCredit(@PathVariable("id") String SId,@PathVariable("major") String mId) {
		return svc.getStudentCredit(SId,mId);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/getCourseOffers/{id}/{major}/{courseType}")
	public List<CoursesOfferResponse> getCourseOffers(@PathVariable("id") String SId,@PathVariable("major") String mId,@PathVariable("courseType") String ctype) {
		return svc.getCourseOffers(SId,mId,ctype);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/lms/registerCourses")
	public List<RegisterCoursesResponse> registerCourses(@RequestBody RegisterCoursesQuery fc) {
		return svc.registerCourses(fc);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/lms/acceptRegisterCourses")
	public List<RegisterCoursesResponse> acceptRegisterCourses(@RequestBody AcceptRegisterCoursesQuery fc) {
		return svc.acceptRegisterCourses(fc);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/getContractSheet/{id}/{major}")
	public List<StudentContractSheet> getContractSheet(@PathVariable("id") String SId,@PathVariable("major") String mId) {
		return svc.getContractSheet(SId,mId);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/getStudentProbation/{id}/{major}")
	public String getStudentProbation(@PathVariable("id") String SId,@PathVariable("major") String mId) {
		return svc.getStudentProbation(SId,mId);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/getStudentPaymentInfo/{id}/{major}")
	public StudentPaymentInfoResponse getStudentPaymentInfo(@PathVariable("id") String SId,@PathVariable("major") String mId) {
		return svc.getStudentPaymentInfo(SId,mId);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/getStudentAmount/{id}/{major}")
	public AvhFinancialAccount getStudentAmount(@PathVariable("id") String SId,@PathVariable("major") String mId) {
		return svc.getStudentAmount(SId,mId);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/getStudentHistoryInfo/{id}/{major}")
	public StudentHistoryInfoResponse getStudentHistoryInfo(@PathVariable("id") String SId,@PathVariable("major") String mId) {
		return svc.getStudentHistoryInfo(SId,mId);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/getStudentStudyYears/{id}/{major}")
	public List<Integer> getStudentStudyYears(@PathVariable("id") String SId,@PathVariable("major") String mId) {
		return svc.getStudentStudyYears(SId,mId);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/getStudentStudySemester/{id}/{major}/{year}")
	public List<String> getStudentStudySemester(@PathVariable("id") String SId,@PathVariable("major") String mId,@PathVariable("year") int year) {
		return svc.getStudentStudySemester(SId,mId,year);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/getStudentHistoryCourses/{id}/{major}/{semester}")
	public List<StudentCourseHistoryResponse> getStudentHistoryCourses(@PathVariable("id") String SId,@PathVariable("major") String mId,@PathVariable("semester") String semester) {
		return svc.getStudentHistoryCourses(SId,mId,semester);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/getStudentCheckAccountInfo/{id}/{major}")
	public StudentCheckAccountInfoResponse getStudentCheckAccountInfo(@PathVariable("id") String SId,@PathVariable("major") String mId) {
		return svc.getStudentCheckAccountInfo(SId,mId);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/getCheckAccountInfo/{from}/{to}/{userId}/{major}")
	public CheckAccountInfoResponse getCheckAccountInfo(@PathVariable("userId") String userId,
														@PathVariable("major") String major,
														@PathVariable("from") String from,
														@PathVariable("to") String to){
			
//			@RequestBody CheckAccountInfoQuery fc) {
		CheckAccountInfoQuery fc = new CheckAccountInfoQuery();
		fc.setFrom(LocalDate.parse(from));
		fc.setMajor(major);
		fc.setTo(LocalDate.parse(to));
		fc.setUserId(userId);
		return svc.getCheckAccountInfo(fc);
	}
	
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/getStudentCurrentSemesterInfo/{id}/{major}")
	public StudentCurrentSemesterInfoResponse getStudentCurrentSemesterInfo(@PathVariable("id") String SId,@PathVariable("major") String mId) {
		return svc.getStudentCurrentSemesterInfo(SId,mId);
	}
	
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/getCurrentSemesterInfo/{id}/{major}")
	public CurrentSemesterInfoResponse getCurrentSemesterInfo(@PathVariable("id") String SId,@PathVariable("major") String mId) {
		return svc.getCurrentSemesterInfo(SId,mId);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/lms/dropCourses")
	public List<DropCoursesResponse> dropCourses(@RequestBody DropCoursesQuery fc) {
		return svc.dropCourses(fc);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/getStudentCurrentSem/{id}/{major}")
	public String getStudentCurrentSem(@PathVariable("id") String SId,@PathVariable("major") String mId) {
		return svc.getStudentCurrentSem(SId,mId);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/lms/pay")
	public String pay(@RequestBody PaymentQuery fc) {
		return svc.pay(fc);
	}
	
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/getStudentCalendar/{id}/{major}")
	public List<StudentCalendarResponse> getStudentCalendar(@PathVariable("id") String SId,@PathVariable("major") String mId) {
		return svc.getStudentCalendar(SId,mId);
	}
	
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/testSplit/{id}/{major}")
	public int testSplit(@PathVariable("id") String SId,@PathVariable("major") String mId) {
		return svc.testSplit(SId,mId);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/AllEnrolment")
	public List<AllEnrolmentResponse> allEnrolment() {
		return svc.allEnrolment();
	}
}
