package avh.nuversity.lms.services.impl.rep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AvhRep {
	@Autowired
	private StudentRep studentRep;
	@Autowired
	private SemesterRep semesterRep;
	@Autowired
	private UniversityRep universityRep;
	@Autowired
	private CampusRep campusRep;
	@Autowired
	private CourseRep courseRep;
	@Autowired
	private DepartmentRep departmentRep;
	@Autowired
	private FacultyRep facultyRep;
	@Autowired
	private MajorRep majorRep;
	@Autowired
	private ProgramRep programRep;
	@Autowired
	private TeacherRep teacherRep;
	@Autowired
	private ApplicantRep applicantRep;
	@Autowired
	private ApplicationRep applicationRep;
	@Autowired
	private AppDocRep appDocrep;
	@Autowired
	private StudentMajorRep stdMajorRep;
	@Autowired
	private CourseCompRep courseCompRep;
	@Autowired
	private MajorCourseRep majorCourseRep;
	@Autowired
	private CourseOfferingRep courseOfferingRep;
	@Autowired
	private EnrolmentRequestRep enrolmentRequestRep;
	@Autowired
	private SubscriptionRep subscriptionRep;
	@Autowired
	private ContractSheetRep contractSheetRep;
	@Autowired
	private GlobalGpaRep globalGpaRep;
	@Autowired
	private OfferGradeFormatRep offerGradeFormat;
	@Autowired
	private OfferGradeLineRep offerGradelineRep;
	public OfferGradeLineRep getOfferGradelineRep() {
		return offerGradelineRep;
	}

	public void setOfferGradelineRep(OfferGradeLineRep offerGradelineRep) {
		this.offerGradelineRep = offerGradelineRep;
	}

	@Autowired
	private CourseOfferScheduleRep courseOfferScheduleRep;
	@Autowired
	private MajorReqDocRep majorReqDocRep;
	@Autowired
	private FinancialAccountRep finantialAccountRep;
	@Autowired
	private FinancialOperationRep finantialOperationRep;
	@Autowired
	private FinancialOperationDocRep finantialOperationDocRep;
	@Autowired
	private EnrolmentGradeRep enrolmentGradeRep;	
	public EnrolmentGradeRep getEnrolmentGradeRep() {
		return enrolmentGradeRep;
	}

	public void setEnrolmentGradeRep(EnrolmentGradeRep enrolmentGradeRep) {
		this.enrolmentGradeRep = enrolmentGradeRep;
	}

	public MajorReqDocRep getMajorReqDocRep() {
		return majorReqDocRep;
	}

	public FinancialAccountRep getFinantialAccountRep() {
		return finantialAccountRep;
	}

	public void setFinantialAccountRep(FinancialAccountRep finantialAccountRep) {
		this.finantialAccountRep = finantialAccountRep;
	}

	public FinancialOperationRep getFinantialOperationRep() {
		return finantialOperationRep;
	}

	public void setFinantialOperationRep(FinancialOperationRep finantialOperationRep) {
		this.finantialOperationRep = finantialOperationRep;
	}

	public FinancialOperationDocRep getFinantialOperationDocRep() {
		return finantialOperationDocRep;
	}

	public void setFinantialOperationDocRep(FinancialOperationDocRep finantialOperationDocRep) {
		this.finantialOperationDocRep = finantialOperationDocRep;
	}

	public void setMajorReqDocRep(MajorReqDocRep majorReqDocRep) {
		this.majorReqDocRep = majorReqDocRep;
	}

	public CourseOfferScheduleRep getCourseOfferScheduleRep() {
		return courseOfferScheduleRep;
	}

	public void setCourseOfferScheduleRep(CourseOfferScheduleRep courseOfferScheduleRep) {
		this.courseOfferScheduleRep = courseOfferScheduleRep;
	}

	public OfferGradeFormatRep getOfferGradeFormat() {
		return offerGradeFormat;
	}

	public void setOfferGradeFormat(OfferGradeFormatRep offerGradeFormat) {
		this.offerGradeFormat = offerGradeFormat;
	}

	@Autowired
	private StudentCoursesRep studentCoursesRep;
	public StudentCoursesRep getStudentCoursesRep() {
		return studentCoursesRep;
	}

	public void setStudentCoursesRep(StudentCoursesRep studentCoursesRep) {
		this.studentCoursesRep = studentCoursesRep;
	}

	public GlobalGpaRep getGlobalGpaRep() {
		return globalGpaRep;
	}

	public void setGlobalGpaRep(GlobalGpaRep globalGpaRep) {
		this.globalGpaRep = globalGpaRep;
	}

	public ContractSheetRep getContractSheetRep() {
		return contractSheetRep;
	}

	public void setContractSheetRep(ContractSheetRep contractSheetRep) {
		this.contractSheetRep = contractSheetRep;
	}

	public EnrolmentRequestRep getEnrolmentRequestRep() {
		return enrolmentRequestRep;
	}

	public void setEnrolmentRequestRep(EnrolmentRequestRep enrolmentRequestRep) {
		this.enrolmentRequestRep = enrolmentRequestRep;
	}

	public SubscriptionRep getSubscriptionRep() {
		return subscriptionRep;
	}

	public void setSubscriptionRep(SubscriptionRep subscriptionRep) {
		this.subscriptionRep = subscriptionRep;
	}

	public CourseOfferingRep getCourseOfferingRep() {
		return courseOfferingRep;
	}

	public void setCourseOfferingRep(CourseOfferingRep courseOfferingRep) {
		this.courseOfferingRep = courseOfferingRep;
	}

	public MajorCourseRep getMajorCourseRep() {
		return majorCourseRep;
	}

	public void setMajorCourseRep(MajorCourseRep majorCourseRep) {
		this.majorCourseRep = majorCourseRep;
	}

	public CourseCompRep getCourseCompRep() {
		return courseCompRep;
	}

	public void setCourseCompRep(CourseCompRep courseCompRep) {
		this.courseCompRep = courseCompRep;
	}

	public StudentMajorRep getStdMajorRep() {
		return stdMajorRep;
	}

	public void setStdMajorRep(StudentMajorRep stdMajorRep) {
		this.stdMajorRep = stdMajorRep;
	}

	public AppDocRep getAppDocrep() {
		return appDocrep;
	}

	public void setAppDocrep(AppDocRep appDocrep) {
		this.appDocrep = appDocrep;
	}

	public ApplicantRep getApplicantRep() {
		return applicantRep;
	}

	public void setApplicantRep(ApplicantRep applicantRep) {
		this.applicantRep = applicantRep;
	}

	public ApplicationRep getApplicationRep() {
		return applicationRep;
	}

	public void setApplicationRep(ApplicationRep applicationRep) {
		this.applicationRep = applicationRep;
	}

	public CampusRep getCampusRep() {
		return campusRep;
	}

	public void setCampusRep(CampusRep campusRep) {
		this.campusRep = campusRep;
	}

	public CourseRep getCourseRep() {
		return courseRep;
	}

	public void setCourseRep(CourseRep courseRep) {
		this.courseRep = courseRep;
	}

	public DepartmentRep getDepartmentRep() {
		return departmentRep;
	}

	public void setDepartmentRep(DepartmentRep departmentRep) {
		this.departmentRep = departmentRep;
	}

	public FacultyRep getFacultyRep() {
		return facultyRep;
	}

	public void setFacultyRep(FacultyRep facultyRep) {
		this.facultyRep = facultyRep;
	}

	public MajorRep getMajorRep() {
		return majorRep;
	}

	public void setMajorRep(MajorRep majorRep) {
		this.majorRep = majorRep;
	}

	public ProgramRep getProgramRep() {
		return programRep;
	}

	public void setProgramRep(ProgramRep programRep) {
		this.programRep = programRep;
	}

	public TeacherRep getTeacherRep() {
		return teacherRep;
	}

	public void setTeacherRep(TeacherRep teacherRep) {
		this.teacherRep = teacherRep;
	}

	public UniversityRep getUniversityRep() {
		return universityRep;
	}

	public void setUniversityRep(UniversityRep universityRep) {
		this.universityRep = universityRep;
	}

	public AvhRep() {}

	public StudentRep getStudentRep() {
		return studentRep;
	}

	public void setStudentRep(StudentRep studentRep) {
		this.studentRep = studentRep;
	}
	
	public SemesterRep getSemesterRep() {
		return semesterRep;
	}

	public void setSemesterRep(SemesterRep semesterRep) {
		this.semesterRep = semesterRep;
	}

	
	
	
}
