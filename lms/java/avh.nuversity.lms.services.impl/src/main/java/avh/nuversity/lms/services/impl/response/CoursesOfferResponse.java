package avh.nuversity.lms.services.impl.response;

import java.util.List;

import avh.nuversity.lms.model.AvhCourseComp;
import avh.nuversity.lms.model.AvhCourseOffering;

public class CoursesOfferResponse {

	private AvhCourseOffering course;
	
	private List<AvhCourseComp> compList;

	public AvhCourseOffering getCourse() {
		return course;
	}

	public void setCourse(AvhCourseOffering course) {
		this.course = course;
	}

	public List<AvhCourseComp> getCompList() {
		return compList;
	}

	public void setCompList(List<AvhCourseComp> compList) {
		this.compList = compList;
	}
}
