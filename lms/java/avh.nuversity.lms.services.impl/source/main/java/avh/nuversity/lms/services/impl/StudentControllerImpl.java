package avh.nuversity.lms.services.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import avh.nuversity.lms.model.AvhApplication;
import avh.nuversity.lms.model.AvhCampus;
import avh.nuversity.lms.model.AvhContractSheet;
import avh.nuversity.lms.model.AvhCourse;
import avh.nuversity.lms.model.AvhCourseComp;
import avh.nuversity.lms.model.AvhCourseOfferSchedule;
import avh.nuversity.lms.model.AvhCourseOffering;
import avh.nuversity.lms.model.AvhEnrolmentGrade;
import avh.nuversity.lms.model.AvhEnrolmentRequest;
import avh.nuversity.lms.model.AvhFinancialAccount;
import avh.nuversity.lms.model.AvhFinancialDocument;
import avh.nuversity.lms.model.AvhFinancialOperation;
import avh.nuversity.lms.model.AvhGlobalGpa;
import avh.nuversity.lms.model.AvhMajorCourse;
import avh.nuversity.lms.model.AvhSemester;
import avh.nuversity.lms.model.AvhStudent;

import avh.nuversity.lms.model.AvhStudentMajor;
import avh.nuversity.lms.model.AvhSubscription;
import avh.nuversity.lms.services.impl.query.AcceptRegisterCoursesQuery;
import avh.nuversity.lms.services.impl.query.CheckAccountInfoQuery;
import avh.nuversity.lms.services.impl.query.CreateStudentQuery;
import avh.nuversity.lms.services.impl.query.DropCoursesQuery;
import avh.nuversity.lms.services.impl.query.EnrolmentRequestQuery;
import avh.nuversity.lms.services.impl.query.PaymentQuery;
import avh.nuversity.lms.services.impl.query.RegisterCoursesQuery;
import avh.nuversity.lms.services.impl.query.SubscribeStudentSemesterQuery;
import avh.nuversity.lms.services.impl.rep.AvhRep;
import avh.nuversity.lms.services.impl.response.AllEnrolmentResponse;
import avh.nuversity.lms.services.impl.response.AllPendingStudentResponse;
import avh.nuversity.lms.services.impl.response.CheckAccountInfoResponse;
import avh.nuversity.lms.services.impl.response.CoursesOfferResponse;
import avh.nuversity.lms.services.impl.response.CurrentSemesterCourseListResponse;
import avh.nuversity.lms.services.impl.response.CurrentSemesterInfoResponse;
import avh.nuversity.lms.services.impl.response.DropCoursesResponse;
import avh.nuversity.lms.services.impl.response.OperationResponse;
import avh.nuversity.lms.services.impl.response.RegisterCoursesResponse;
import avh.nuversity.lms.services.impl.response.StudentCalendarResponse;
import avh.nuversity.lms.services.impl.response.StudentCheckAccountInfoResponse;
import avh.nuversity.lms.services.impl.response.StudentContractSheet;
import avh.nuversity.lms.services.impl.response.StudentCourseHistoryResponse;
import avh.nuversity.lms.services.impl.response.StudentCreditResponse;
import avh.nuversity.lms.services.impl.response.StudentCurrentSemesterInfoResponse;
import avh.nuversity.lms.services.impl.response.StudentHistoryInfoResponse;
import avh.nuversity.lms.services.impl.response.StudentPaymentInfoResponse;
import enums.ApplicationStatus;
import enums.CourseComp;
import enums.Currency;
import enums.EnrolmentStatus;
import enums.FOperationType;

@Component
public class StudentControllerImpl {
	@Autowired
	private AvhRep rep;
	public AvhStudent getStudent(String cttId) {
		
		return rep.getStudentRep().findByUserid(cttId);
	}
	public AvhStudent createStudent(CreateStudentQuery fc) {
		AvhStudent  std = new AvhStudent();
		std.setIid(fc.getUserid());
		std.setUserid(fc.getUserid());
		std.setUniversity(fc.getUniversity());
		std.setCampus(fc.getCampus());
		rep.getStudentRep().save(std);
		
		AvhStudentMajor smj = new AvhStudentMajor();
		smj.setIid(UUID.randomUUID().toString());
		smj.setMajorid(fc.getMajorid());
		smj.setStudent(std);
		rep.getStdMajorRep().save(smj);
		
		AvhFinancialAccount fa = new AvhFinancialAccount();
		fa.setAmount(0);
		fa.setUserid(fc.getUserid());
		fa.setIid(UUID.randomUUID().toString());
		fa.setCurrency(Currency.USD.toString());
		fa.setAccountType("Student");
		rep.getFinantialAccountRep().save(fa);
		
		AvhGlobalGpa ggpa = new AvhGlobalGpa();
		ggpa.setGpa(BigDecimal.valueOf(0));
		ggpa.setStudentmajorid(smj.getIid());
		ggpa.setIid(UUID.randomUUID().toString());
		rep.getGlobalGpaRep().save(ggpa);
		
		AvhApplication application = rep.getApplicationRep().findByApplicantBean(rep.getApplicantRep().findByIid(fc.getUserid()));
		application.setStatus(ApplicationStatus.ACCEPTED.toString());
		rep.getApplicationRep().save(application);
		return std;
	}
	
	public String subscribeSemester(SubscribeStudentSemesterQuery fc) {
		
		AvhSubscription sub = new AvhSubscription();
		sub.setOyear(fc.getOyear());
		sub.setSemesterBean(rep.getSemesterRep().findByIid(fc.getSemester()));
		sub.setStudentBean(rep.getStudentRep().findByUserid(fc.getStudent()));
		sub.setIid(UUID.randomUUID().toString());
		rep.getSubscriptionRep().save(sub);
		return ErrorCode.Success;
	}
	
	
	public String enrolmentRequest(EnrolmentRequestQuery fc) {
		AvhEnrolmentRequest enr = new AvhEnrolmentRequest();
		enr.setCourseOffering(rep.getCourseOfferingRep().findByIid(fc.getOffer()));
		enr.setStudentBean(rep.getStudentRep().findByUserid(fc.getStudent()));
		enr.setRequestDate(LocalDate.now());
		enr.setStatus(EnrolmentStatus.PENDING.toString());
		enr.setReason(null);
		enr.setIid(UUID.randomUUID().toString());
		
		rep.getEnrolmentRequestRep().save(enr);
		return ErrorCode.Success;
	}
	
	public AvhCampus getStudentCampus(String cttId) {
		return rep.getCampusRep().findByIid(rep.getStudentRep().findByUserid(cttId).getCampus());
		
	}
	public AvhGlobalGpa getStudentGlobalGPA(String sId, String mId) {
		
		List<AvhStudentMajor> ls = rep.getStdMajorRep().findByStudent(rep.getStudentRep().findByUserid(sId));
		AvhStudentMajor sm = null;
		for (AvhStudentMajor avhSM : ls) {
			if(avhSM.getMajorid().equals(mId)) {
				sm=avhSM;
			}
		}
		
		
		return rep.getGlobalGpaRep().findByStudentmajorid(sm.getIid());
	}
	
	
	public StudentCreditResponse getStudentCredit(String sId, String mId) {
		
		int totalPassedCrd = 0;
		StudentCreditResponse response = new StudentCreditResponse();
	
		List<AvhEnrolmentRequest> listEnrolmentCourses = rep.getEnrolmentRequestRep().findByStudentBean(rep.getStudentRep().findByUserid(sId));
		for (AvhEnrolmentRequest enr : listEnrolmentCourses) {
			if(enr.getStatus().equals(EnrolmentStatus.PASSED.toString())) {
				totalPassedCrd+=enr.getCourseOffering().getCourseBean().getCredit();
			}
		}
		
		response.setPassedCrd(totalPassedCrd);
		
		AvhContractSheet csheet = rep.getContractSheetRep().findByMajorBean(rep.getMajorRep().findByIid(mId));
		int totalCrd = csheet.getCoreCredit() + csheet.getMajorCredit() + csheet.getElectiveCredit() + csheet.getGeneralCredit();
		
		response.setRemainingCrd(totalCrd - totalPassedCrd);
		response.setStudentId(sId);
		
		
		
		return response;
	}
	
	
	public List<CoursesOfferResponse> getCourseOffers(String sId, String mId, String courseType) {
		
		List<CoursesOfferResponse> resp = new ArrayList<CoursesOfferResponse>();
		
		List<AvhCourseOffering> lco = findAllCoursesOffersForStudent(sId,mId,courseType);
		for (AvhCourseOffering co : lco) {
			CoursesOfferResponse cor = new CoursesOfferResponse();
			cor.setCourse(co);
			
			List<AvhCourseComp> lcc = getCourseComp(co.getCourseBean());
			cor.setCompList(lcc);
			
			resp.add(cor);
		}
		
		
		
		
		return resp;
	}
	
	private List<AvhCourseComp> getCourseComp(AvhCourse courseBean) {
		
		List<AvhCourseComp> resp = new ArrayList<AvhCourseComp>();
		List<AvhCourseComp> ls = rep.getCourseCompRep().findByCourse(courseBean);
		for (AvhCourseComp cc : ls) {
			if(! cc.getCompType().equals(CourseComp.PREREQUISITES.toString())) {
				resp.add(cc);
			}
		}
		
		return resp;
	}
	private List<AvhCourseOffering> findAllCoursesOffersForStudent(String sId,String mId,String courseType){

		List<AvhCourseOffering> resp = new ArrayList<AvhCourseOffering>();
		
		List<AvhMajorCourse> majorC = rep.getMajorCourseRep().findByMajorBean(rep.getMajorRep().findByIid(mId));
		List<AvhCourse> lcourses = new ArrayList<AvhCourse>();
		for (AvhMajorCourse mc : majorC) {
			if(mc.getCourseType().equals(courseType)) {
			lcourses.add(mc.getCourseBean());
			}
		}
		
		List<AvhCourseOffering> lcoursO = rep.getCourseOfferingRep().findAll();
		for (AvhCourse crs : lcourses) {
			boolean done = testIfCoursePassed(crs,sId);
			if(!done) {
				LocalDate date = LocalDate.now();
				for (AvhCourseOffering cof : lcoursO) {
					if(cof.getCourseBean().equals(crs) && cof.getEffectiveDate().compareTo(date)<=0 && cof.getExpiryDat().compareTo(date)>0) {
						boolean canReg = testIfCanRegisterCourse(crs,sId);
						if(canReg) {
							resp.add(cof);
						}
					}
				}
			}
		}
		
		
		
		return resp;
	}
	
	private boolean testIfCanRegisterCourse(AvhCourse crs, String sId) {
			
			List<AvhCourseComp> lst = rep.getCourseCompRep().findByCourse(crs);
			
			for (AvhCourseComp cc : lst) {
				if(cc.getCompType().equals(CourseComp.PREREQUISITES.toString())) {
					boolean test = testIfCoursePassedTrue(cc.getCourseCmp(), sId);
					if(!test) {
						return false;
					}
				}
			}
			
			
			return true;
		}

	
	private boolean testIfCoursePassed(AvhCourse crs, String std) {
		List<AvhEnrolmentRequest> lst = rep.getEnrolmentRequestRep().findByStudentBean(rep.getStudentRep().findByUserid(std));
		
		for (AvhEnrolmentRequest er : lst) {
			if(er.getCourseOffering().getCourseBean().equals(crs)) {
				if( er.getStatus().equals(EnrolmentStatus.PASSED.toString()) || er.getStatus().equals(EnrolmentStatus.PENDING.toString()) || er.getStatus().equals(EnrolmentStatus.ACCEPTED.toString())){
					return true;
				}
				
			}
		}
		return false;
	}
	
	private boolean testIfCoursePassedTrue(AvhCourse crs, String std) {
		List<AvhEnrolmentRequest> lst = rep.getEnrolmentRequestRep().findByStudentBean(rep.getStudentRep().findByUserid(std));
		
		for (AvhEnrolmentRequest er : lst) {
			if(er.getCourseOffering().getCourseBean().equals(crs) && er.getStatus().equals(EnrolmentStatus.PASSED.toString())) {
					return true;

			}
		}
		return false;
	}
	
	
	public List<RegisterCoursesResponse> registerCourses(RegisterCoursesQuery fc) {
		
		List<RegisterCoursesResponse> resp = new ArrayList<RegisterCoursesResponse>();
		AvhStudent std = rep.getStudentRep().findByUserid(fc.getStudentId());
		for (String course : fc.getCourses()) {
			RegisterCoursesResponse cres = new RegisterCoursesResponse();
			AvhCourseOffering crs = rep.getCourseOfferingRep().findByIid(course);
			AvhEnrolmentRequest enr = new AvhEnrolmentRequest();
			enr.setCourseOffering(crs);
			enr.setReason(null);
			enr.setRequestDate(LocalDate.now());
			enr.setStatus(EnrolmentStatus.PENDING.toString());
			enr.setStudentBean(std);
			enr.setIid(UUID.randomUUID().toString());
			rep.getEnrolmentRequestRep().save(enr);
			cres.setCourse(crs.getCourseBean().getIid());
			cres.setStatus(ErrorCode.Success);
			resp.add(cres);
			
		}
		return resp;
	}
	public List<StudentContractSheet> getContractSheet(String sId, String mId) {
		List<StudentContractSheet> response = new ArrayList<StudentContractSheet>();
		AvhContractSheet mcsh = rep.getContractSheetRep().findByMajorBean(rep.getMajorRep().findByIid(mId));
		
		StudentContractSheet required = new StudentContractSheet();
		
		required.setName("required");
		required.setCore(mcsh.getCoreCredit());
		required.setElective(mcsh.getElectiveCredit());
		required.setGeneral(mcsh.getGeneralCredit());
		required.setMajor(mcsh.getMajorCredit());
		response.add(required);
		
		StudentContractSheet aquired = getStudentAquired(sId,mId);

		response.add(aquired);
		
		StudentContractSheet togo = new StudentContractSheet();
		togo.setCore(required.getCore() - aquired.getCore());
		togo.setElective(required.getElective() - aquired.getElective());
		togo.setGeneral(required.getGeneral() - aquired.getGeneral());
		togo.setMajor(required.getMajor() - aquired.getMajor());
		togo.setName("togo");
		response.add(togo);
		
		
		return response;
	}
	
	private StudentContractSheet getStudentAquired(String sId,String mId) {
		
		StudentContractSheet response = new StudentContractSheet();

		
		List<AvhEnrolmentRequest> lst = rep.getEnrolmentRequestRep().findByStudentBean(rep.getStudentRep().findByUserid(sId));
		int aquiredCore = 0,aquiredElective = 0 , aquiredGeneral = 0 , aquiredMajor = 0;
		for (AvhEnrolmentRequest enr : lst) {
			if(enr.getStatus().equals("PASSED")) {
				AvhCourse course= enr.getCourseOffering().getCourseBean();
				List<AvhMajorCourse> lmcourse = rep.getMajorCourseRep().findByMajorBean(rep.getMajorRep().findByIid(mId));
				for (AvhMajorCourse mcourse : lmcourse) {
					if(mcourse.getCourseBean().equals(course)) {
						if(mcourse.getCourseType().equals("CORE")) {
							aquiredCore +=course.getCredit();
						}else if(mcourse.getCourseType().equals("MAJOR")) {
							aquiredMajor +=course.getCredit();
						}else if(mcourse.getCourseType().equals("GENERAL")) {
							aquiredGeneral +=course.getCredit();
						}else {
							aquiredElective +=course.getCredit();
						}
					}
				}
				
			}
		}
		response.setCore(aquiredCore);
		response.setElective(aquiredElective);
		response.setGeneral(aquiredGeneral);
		response.setMajor(aquiredMajor);
		response.setName("aquired");
		return response;
	}
	public String getStudentProbation(String sId, String mId) {
		List<AvhStudentMajor> ls = rep.getStdMajorRep().findByStudent(rep.getStudentRep().findByUserid(sId));
		AvhStudentMajor sm = null;
		for (AvhStudentMajor avhSM : ls) {
			if(avhSM.getMajorid().equals(mId)) {
				sm=avhSM;
			}
		}
		
		
		AvhGlobalGpa gpa = rep.getGlobalGpaRep().findByStudentmajorid(sm.getIid());
		
		if(gpa.getGpa().compareTo(LmsConstants.PROBATION) >0) {
			return "NO";
		}
		return "YES";
	}
	public StudentPaymentInfoResponse getStudentPaymentInfo(String sId, String mId) {
		StudentPaymentInfoResponse response = new StudentPaymentInfoResponse();
		response.setAmount(rep.getFinantialAccountRep().findByUserid(sId).getAmount());
		response.setMajor(rep.getMajorRep().findByIid(mId).getName());
		response.setUserid(sId);
		return response;
	}
	public AvhFinancialAccount getStudentAmount(String sId, String mId) {
		return rep.getFinantialAccountRep().findByUserid(sId);
	}
	public StudentHistoryInfoResponse getStudentHistoryInfo(String sId, String mId) {
		StudentHistoryInfoResponse response = new StudentHistoryInfoResponse();
		response.setMajor(rep.getMajorRep().findByIid(mId).getName());
		response.setUserid(sId);
		return response;
	}
	public List<Integer> getStudentStudyYears(String sId, String mId) {
		List<Integer> response = new ArrayList<Integer>();
		List<AvhSubscription> lst = rep.getSubscriptionRep().findByStudentBean(rep.getStudentRep().findByUserid(sId));
		for (AvhSubscription sub : lst) {
			boolean test = false;
			for (int testRes : response) {
				
				if(sub.getOyear().equals(testRes)) {
					test = true;
				}	
			}
			if(!test) {
				response.add(sub.getOyear());
			}
			
		}
		
		return response;
	}
	public List<String> getStudentStudySemester(String sId, String mId, int year) {
		List<String> response = new ArrayList<String>();
		List<AvhSubscription> lst = rep.getSubscriptionRep().findByStudentBean(rep.getStudentRep().findByUserid(sId));
		for (AvhSubscription sub : lst) {
			if(sub.getOyear() == year) {
				response.add(sub.getSemesterBean().getLabel());
			}
		}
		return response;
	}
	public List<StudentCourseHistoryResponse> getStudentHistoryCourses(String sId, String mId, String semester) {
		List<StudentCourseHistoryResponse> response = new ArrayList<StudentCourseHistoryResponse>();
		
		List<AvhEnrolmentRequest> lenr = rep.getEnrolmentRequestRep().findByStudentBean(rep.getStudentRep().findByUserid(sId));
		for (AvhEnrolmentRequest enr : lenr) {
			if(enr.getCourseOffering().getSemesterBean().getIid().equals(semester)) {
			if(enr.getStatus().equals(EnrolmentStatus.PASSED.toString()) || enr.getStatus().equals(EnrolmentStatus.FAILED.toString())) {
				StudentCourseHistoryResponse res = new StudentCourseHistoryResponse();
				res.setCode(enr.getCourseOffering().getCourseBean().getIid());
				res.setCredit(enr.getCourseOffering().getCourseBean().getCredit());
				res.setName(enr.getCourseOffering().getCourseBean().getTitle());
				res.setStatus(enr.getStatus());
				res.setResult(getCourseResult(enr));
				response.add(res);
			}
			}
		}
		return response;
	}
	
	private String getCourseResult(AvhEnrolmentRequest enr) {
		List<AvhEnrolmentGrade> eglR = new ArrayList<AvhEnrolmentGrade>();
		Iterable<AvhEnrolmentGrade> egl = rep.getEnrolmentGradeRep().findAll();
		for(AvhEnrolmentGrade elmt : egl){
			eglR.add(elmt);
		}

		double res = 0;
		for (AvhEnrolmentGrade gr : eglR) {
			if(gr.getEnrolmentRequestBean().equals(enr.getIid())) {

				
					double grade = (gr.getGrade() * rep.getOfferGradelineRep().findById(gr.getOfferGradeLine()).get().getPercentage().intValue())/100; //gr.getOfferGradeLine().getPercentage() / 100;
					res +=grade;
				
			}
		}
		return ""+res;

	}
	
	public StudentCheckAccountInfoResponse getStudentCheckAccountInfo(String sId, String mId) {
		StudentCheckAccountInfoResponse response = new StudentCheckAccountInfoResponse();
		response.setMajor(rep.getMajorRep().findByIid(mId).getName());
		response.setUserid(sId);
		AvhFinancialAccount acc = rep.getFinantialAccountRep().findByUserid(sId);
		response.setAccount(acc.getIid());
		DecimalFormat df = new DecimalFormat("#.##");
//		response.setAmount(""+acc.getAmount().fo);
		response.setAmount(String.format("%.2f", acc.getAmount() * -1) +" " + acc.getCurrency());
		response.setAsof(LocalDate.now());
		return response;
	}
	public CheckAccountInfoResponse getCheckAccountInfo(CheckAccountInfoQuery fc) {
		CheckAccountInfoResponse response = new CheckAccountInfoResponse();
		
		AvhFinancialAccount acc = rep.getFinantialAccountRep().findByUserid(fc.getUserId());
		response.setAccount(acc.getIid());
		response.setAmount(acc.getAmount());
		response.setAsof(LocalDate.now());
		response.setFrom(fc.getFrom());//LocalDate.of(LocalDate.now().getYear(), 1, 1));
		response.setTo(fc.getTo());//LocalDate.of(LocalDate.now().getYear(), 8, 31));
		
		List<OperationResponse> opres = new ArrayList<OperationResponse>();
		
		List<AvhFinancialOperation> fop = rep.getFinantialOperationRep().findByFinancialAccount(acc);
		for (AvhFinancialOperation fope : fop) {
			if(fope.getOdate().isBefore(response.getTo()) && fope.getOdate().isAfter(response.getFrom())) {
				OperationResponse res = new OperationResponse();
				res.setAmount(fope.getAmount());
				res.setCrdr(fope.getOtype());
				res.setDate(fope.getOdate());
				AvhFinancialDocument doc = rep.getFinantialOperationDocRep().findByFinancialOperation(fope);
				res.setRef(doc.getIid());//doc.getIid());
				opres.add(res);
			}
		}
		
		response.setOperations(opres);
		// TODO fix repository of financial operation doc
		return response;
	}
	
	public StudentCurrentSemesterInfoResponse getStudentCurrentSemesterInfo(String sId, String mId) {
		StudentCurrentSemesterInfoResponse response = new StudentCurrentSemesterInfoResponse();
		response.setMajor(rep.getMajorRep().findByIid(mId).getName());
		response.setUserid(sId);
		return response;
	}
	
	
	public CurrentSemesterInfoResponse getCurrentSemesterInfo(String sId, String mId) {
		CurrentSemesterInfoResponse response = new CurrentSemesterInfoResponse();
		
		List<AvhSubscription> subList = rep.getSubscriptionRep().findByStudentBean(rep.getStudentRep().findByUserid(sId));
		
		AvhSubscription currentSubscription = subList.get(subList.size()-1);
		response.setDate(LocalDate.now());
		response.setSemester(currentSubscription.getSemesterBean().getIid());
		response.setYear(currentSubscription.getOyear());
		
		List<AvhEnrolmentRequest> lenr = rep.getEnrolmentRequestRep().findByStudentBean(rep.getStudentRep().findByUserid(sId));
		List<CurrentSemesterCourseListResponse> courses = new ArrayList<CurrentSemesterCourseListResponse>();
		for (AvhEnrolmentRequest enr : lenr) {
			if(enr.getCourseOffering().getSemesterBean().getIid().equals(response.getSemester()) && enr.getStatus().equals(EnrolmentStatus.ACCEPTED.toString())) {
				CurrentSemesterCourseListResponse course = new CurrentSemesterCourseListResponse();
						course.setCode(enr.getCourseOffering().getCourseBean().getIid());
						course.setTitle(enr.getCourseOffering().getCourseBean().getTitle());
						course.setEnrolmentid(enr.getIid());
						courses.add(course);
			}
		}
		
		response.setCourses(courses);
		return response;
	}
	
	public List<DropCoursesResponse> dropCourses(DropCoursesQuery fc) {
		
		List<DropCoursesResponse> response= new ArrayList<DropCoursesResponse>();
		for (String enr : fc.getCourses()) {
			DropCoursesResponse res = new DropCoursesResponse();
			AvhEnrolmentRequest enrolment = rep.getEnrolmentRequestRep().findByIid(enr);
			enrolment.setStatus(EnrolmentStatus.DROPED.toString());
			rep.getEnrolmentRequestRep().save(enrolment);
			res.setCourse(enrolment.getCourseOffering().getCourseBean().getIid());
			res.setStatus(ErrorCode.Success);
			response.add(res);
		}
		
		return response;
	}
	public String getStudentCurrentSem(String sId, String mId) {
		List<AvhSubscription> subList = rep.getSubscriptionRep().findByStudentBean(rep.getStudentRep().findByUserid(sId));
		
		AvhSubscription currentSubscription = subList.get(subList.size()-1);
		
		return currentSubscription.getSemesterBean().getIid();
	}
	public List<RegisterCoursesResponse> acceptRegisterCourses(AcceptRegisterCoursesQuery fc) {
		
		List<RegisterCoursesResponse> resp = new ArrayList<RegisterCoursesResponse>();
		AvhStudent std = rep.getStudentRep().findByUserid(fc.getStudentId());
		for (String course : fc.getCourses()) {
			RegisterCoursesResponse cres = new RegisterCoursesResponse();
			AvhEnrolmentRequest enr = rep.getEnrolmentRequestRep().findByIid(course);
			
			enr.setStatus(EnrolmentStatus.ACCEPTED.toString());
			rep.getEnrolmentRequestRep().save(enr);
			cres.setCourse(course);
			cres.setStatus(ErrorCode.Success);
			resp.add(cres);
			AvhFinancialAccount fac = rep.getFinantialAccountRep().findByUserid(std.getIid());
			int courseCost = (enr.getCourseOffering().getCourseBean().getCredit() * rep.getMajorRep().findByIid(fc.getMajorId()).getCreditCost().intValue());
			fac.setAmount(fac.getAmount() + courseCost);
			rep.getFinantialAccountRep().save(fac);
			
			AvhFinancialOperation fao = new AvhFinancialOperation();
			fao.setAmount(BigDecimal.valueOf(courseCost));
			fao.setComments("Registration of "+enr.getCourseOffering().getCourseBean().getIid());
			fao.setFinancialAccount(fac);
			fao.setIid(UUID.randomUUID().toString());
			fao.setMsg(course);
			fao.setOdate(LocalDate.now());
			fao.setOtype(FOperationType.DR.toString());
			rep.getFinantialOperationRep().save(fao);
			
			AvhFinancialDocument fod = new AvhFinancialDocument();
			fod.setDocref(BigDecimal.valueOf(10));
			fod.setFinancialOperation(fao);
			Random rand = new Random();
			fod.setIid("I-"+ (rand.nextInt(900)+100));
			rep.getFinantialOperationDocRep().save(fod);
			
			AvhCourseOffering cof = rep.getCourseOfferingRep().findByIid(enr.getCourseOffering().getIid());
			cof.setCapacity(cof.getCapacity() - 1);
			rep.getCourseOfferingRep().save(cof);
		}
		return resp;
	}
	public String pay(PaymentQuery fc) {
		AvhFinancialAccount fac = rep.getFinantialAccountRep().findByUserid(fc.getUserId());
		fac.setAmount(fac.getAmount() - fc.getAmount());
		rep.getFinantialAccountRep().save(fac);
		
		AvhFinancialOperation fao = new AvhFinancialOperation();
		fao.setAmount(BigDecimal.valueOf(fc.getAmount()));
		fao.setComments("Pay");
		fao.setFinancialAccount(fac);
		fao.setIid(UUID.randomUUID().toString());
		fao.setMsg("Payment By"+fc.getNameOncard());
		fao.setOdate(LocalDate.now());
		fao.setOtype(FOperationType.CR.toString());
		rep.getFinantialOperationRep().save(fao);
		
		AvhFinancialDocument fod = new AvhFinancialDocument();
		fod.setDocref(BigDecimal.valueOf(10));
		fod.setFinancialOperation(fao);
		Random rand = new Random();
		fod.setIid("O-"+ (rand.nextInt(900)+100));
		rep.getFinantialOperationDocRep().save(fod);
		
		return ErrorCode.Success;
	}
	

	
	public List<StudentCalendarResponse> getStudentCalendar(String sId, String mId) {
		List<StudentCalendarResponse> response = new ArrayList<StudentCalendarResponse>();
		LocalDate startDate = LocalDate.of(2021, 10, 01);
		LocalDate endDate = LocalDate.of(2022, 02, 01);
		List<AvhEnrolmentRequest> lenr = rep.getEnrolmentRequestRep().findByStudentBean(rep.getStudentRep().findByUserid(sId));
		for (AvhEnrolmentRequest enr : lenr) {
			if(enr.getStatus().equals(EnrolmentStatus.ACCEPTED.toString())) {
				AvhCourseOfferSchedule schedule = rep.getCourseOfferScheduleRep().findByOffer(enr.getCourseOffering().getIid());
				for(LocalDate date = startDate; date.isBefore(endDate); date=date.plusDays(1)) {
					if(date.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
						if(schedule.getMonday().length() > 0) {
							String[] time = schedule.getMonday().split(" ");
							String[] begin = time[0].split(":");
							int startHour = Integer.parseInt(begin[0]);
							int StartMin = Integer.parseInt(begin[1]);
							
							String[] end = time[2].split(":");
							int endHour = Integer.parseInt(end[0]);
							int endMin = Integer.parseInt(end[1]);
							StudentCalendarResponse res = new StudentCalendarResponse();
							res.setTitle(enr.getCourseOffering().getCourseBean().getIid());
							res.setStartYear(date.getYear());
							res.setStartMonth(date.getMonthValue() - 1);
							res.setStartDay(date.getDayOfMonth());
							res.setStartHour(startHour);
							res.setStartMin(StartMin);
							
							res.setEndYear(date.getYear());
							res.setEndMonth(date.getMonthValue() - 1);
							res.setEndDay(date.getDayOfMonth());
							res.setEndHour(endHour);
							res.setEndMin(endMin);
							
							response.add(res);
						}
					}
					
						if(date.getDayOfWeek().equals(DayOfWeek.TUESDAY)) {
							if(schedule.getTuesday().length() > 0) {
								String[] time = schedule.getTuesday().split(" ");
								String[] begin = time[0].split(":");
								int startHour = Integer.parseInt(begin[0]);
								int StartMin = Integer.parseInt(begin[1]);
								
								String[] end = time[2].split(":");
								int endHour = Integer.parseInt(end[0]);
								int endMin = Integer.parseInt(end[1]);
								StudentCalendarResponse res = new StudentCalendarResponse();
								res.setTitle(enr.getCourseOffering().getCourseBean().getIid());
								res.setStartYear(date.getYear());
								res.setStartMonth(date.getMonthValue() - 1);
								res.setStartDay(date.getDayOfMonth());
								res.setStartHour(startHour);
								res.setStartMin(StartMin);
								
								res.setEndYear(date.getYear());
								res.setEndMonth(date.getMonthValue() - 1);
								res.setEndDay(date.getDayOfMonth());
								res.setEndHour(endHour);
								res.setEndMin(endMin);
								
								response.add(res);
							}
						}
							if(date.getDayOfWeek().equals(DayOfWeek.WEDNESDAY)) {
								if(schedule.getWednesday().length() > 0) {
									String[] time = schedule.getWednesday().split(" ");
									String[] begin = time[0].split(":");
									int startHour = Integer.parseInt(begin[0]);
									int StartMin = Integer.parseInt(begin[1]);
									
									String[] end = time[2].split(":");
									int endHour = Integer.parseInt(end[0]);
									int endMin = Integer.parseInt(end[1]);
									StudentCalendarResponse res = new StudentCalendarResponse();
									res.setTitle(enr.getCourseOffering().getCourseBean().getIid());
									res.setStartYear(date.getYear());
									res.setStartMonth(date.getMonthValue() - 1);
									res.setStartDay(date.getDayOfMonth());
									res.setStartHour(startHour);
									res.setStartMin(StartMin);
									
									res.setEndYear(date.getYear());
									res.setEndMonth(date.getMonthValue() - 1);
									res.setEndDay(date.getDayOfMonth());
									res.setEndHour(endHour);
									res.setEndMin(endMin);
									
									response.add(res);
								}
							}
								if(date.getDayOfWeek().equals(DayOfWeek.THURSDAY)) {
									if(schedule.getThursday().length() > 0) {
										String[] time = schedule.getThursday().split(" ");
										String[] begin = time[0].split(":");
										int startHour = Integer.parseInt(begin[0]);
										int StartMin = Integer.parseInt(begin[1]);
										
										String[] end = time[2].split(":");
										int endHour = Integer.parseInt(end[0]);
										int endMin = Integer.parseInt(end[1]);
										StudentCalendarResponse res = new StudentCalendarResponse();
										res.setTitle(enr.getCourseOffering().getCourseBean().getIid());
										res.setStartYear(date.getYear());
										res.setStartMonth(date.getMonthValue() - 1);
										res.setStartDay(date.getDayOfMonth());
										res.setStartHour(startHour);
										res.setStartMin(StartMin);
										
										res.setEndYear(date.getYear());
										res.setEndMonth(date.getMonthValue() - 1);
										res.setEndDay(date.getDayOfMonth());
										res.setEndHour(endHour);
										res.setEndMin(endMin);
										
										response.add(res);
									}
								}
									if(date.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
										if(schedule.getFriday().length() > 0) {
											String[] time = schedule.getFriday().split(" ");
											String[] begin = time[0].split(":");
											int startHour = Integer.parseInt(begin[0]);
											int StartMin = Integer.parseInt(begin[1]);
											
											String[] end = time[2].split(":");
											int endHour = Integer.parseInt(end[0]);
											int endMin = Integer.parseInt(end[1]);
											StudentCalendarResponse res = new StudentCalendarResponse();
											res.setTitle(enr.getCourseOffering().getCourseBean().getIid());
											res.setStartYear(date.getYear());
											res.setStartMonth(date.getMonthValue() - 1);
											res.setStartDay(date.getDayOfMonth());
											res.setStartHour(startHour);
											res.setStartMin(StartMin);
											
											res.setEndYear(date.getYear());
											res.setEndMonth(date.getMonthValue() - 1);
											res.setEndDay(date.getDayOfMonth());
											res.setEndHour(endHour);
											res.setEndMin(endMin);
											
											response.add(res);
										}
									}
										if(date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
											if(schedule.getSaturday().length() > 0) {
												String[] time = schedule.getSaturday().split(" ");
												String[] begin = time[0].split(":");
												int startHour = Integer.parseInt(begin[0]);
												int StartMin = Integer.parseInt(begin[1]);
												
												String[] end = time[2].split(":");
												int endHour = Integer.parseInt(end[0]);
												int endMin = Integer.parseInt(end[1]);
												StudentCalendarResponse res = new StudentCalendarResponse();
												res.setTitle(enr.getCourseOffering().getCourseBean().getIid());
												res.setStartYear(date.getYear());
												res.setStartMonth(date.getMonthValue() - 1);
												res.setStartDay(date.getDayOfMonth());
												res.setStartHour(startHour);
												res.setStartMin(StartMin);
												
												res.setEndYear(date.getYear());
												res.setEndMonth(date.getMonthValue() - 1);
												res.setEndDay(date.getDayOfMonth());
												res.setEndHour(endHour);
												res.setEndMin(endMin);
												
												response.add(res);
											}
										}
											if(date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
												if(schedule.getSunday().length() > 0) {
													String[] time = schedule.getSunday().split(" ");
													String[] begin = time[0].split(":");
													int startHour = Integer.parseInt(begin[0]);
													int StartMin = Integer.parseInt(begin[1]);
													
													String[] end = time[2].split(":");
													int endHour = Integer.parseInt(end[0]);
													int endMin = Integer.parseInt(end[1]);
													StudentCalendarResponse res = new StudentCalendarResponse();
													res.setTitle(enr.getCourseOffering().getCourseBean().getIid());
													res.setStartYear(date.getYear());
													res.setStartMonth(date.getMonthValue() - 1);
													res.setStartDay(date.getDayOfMonth());
													res.setStartHour(startHour);
													res.setStartMin(StartMin);
													
													res.setEndYear(date.getYear());
													res.setEndMonth(date.getMonthValue() - 1);
													res.setEndDay(date.getDayOfMonth());
													res.setEndHour(endHour);
													res.setEndMin(endMin);
													
													response.add(res);
												
											}
										}
									}
								}
							
						
					
		
		
	
			}
		
	
	
				return response;
	
}
	public int testSplit(String sId, String mId) {
		List<Integer> resp = new ArrayList<Integer>();
		String[] time =null;
		List<AvhEnrolmentRequest> lenr = rep.getEnrolmentRequestRep().findByStudentBean(rep.getStudentRep().findByUserid(sId));
		for (AvhEnrolmentRequest enr : lenr) {
			AvhCourseOfferSchedule sc = rep.getCourseOfferScheduleRep().findByOffer(enr.getCourseOffering().getIid());
			
			 time = sc.getMonday().split(" ");
//			 return time;
			String[] begin = time[0].split(":");
			int e = Integer.parseInt(begin[0]);
			return e;
//			int startHour = Integer.parseInt(begin[0]);
//			int StartMin = Integer.parseInt(begin[1]);
//			resp.add(startHour);
//			resp.add(StartMin);
		}
		return 0;
	}
	public List<AllPendingStudentResponse> allPendingStudent() {
		List<AllPendingStudentResponse> response = new ArrayList<AllPendingStudentResponse>();
		List<AvhApplication> appl = rep.getApplicationRep().findByStatus(ApplicationStatus.PENDING.toString());
		for (AvhApplication application : appl) {
			AllPendingStudentResponse psr = new AllPendingStudentResponse();
			psr.setStudentid(application.getApplicantBean().getUserid());
			psr.setMajorId(application.getMajorBean().getIid());
			psr.setMajorName(application.getMajorBean().getName());
			psr.setCampusId(rep.getCampusRep().findByIid("6f86e6ea-9a87-4ace-9a3e-b7b256a4e712").getIid());
			psr.setCampusName(rep.getCampusRep().findByIid("6f86e6ea-9a87-4ace-9a3e-b7b256a4e712").getName());
			
			response.add(psr);
		}
		return response;
	}
	public List<AllEnrolmentResponse> allEnrolment() {
		List<AllEnrolmentResponse> response = new ArrayList<AllEnrolmentResponse>();
		List<AvhEnrolmentRequest> lst = rep.getEnrolmentRequestRep().findByStatus(EnrolmentStatus.PENDING.toString());
		for (AvhEnrolmentRequest enr : lst) {
			AllEnrolmentResponse res = new AllEnrolmentResponse();
			res.setCourseName(enr.getCourseOffering().getCourseBean().getIid());
			res.setEnrId(enr.getIid());
			res.setMajorId(rep.getStdMajorRep().findByStudent(enr.getStudentBean()).get(0).getMajorid());
			res.setStudentId(enr.getStudentBean().getIid());
			res.setMajorName(rep.getMajorRep().findByIid(rep.getStdMajorRep().findByStudent(enr.getStudentBean()).get(0).getMajorid()).getName());
			response.add(res);
		}
		return response;
	}
	public List<String> getAllSemester() {
		Iterable<AvhSemester> lst = rep.getSemesterRep().findAll();
		List<String> response = new ArrayList<String>();
		for (AvhSemester avhSemester : lst) {
			response.add(avhSemester.getIid());
		}
		
		
		return response;
	}
	
}


