package avh.nuversity.lms.services.impl.rep;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import avh.nuversity.lms.model.AvhCourse;
import avh.nuversity.lms.model.AvhCourseComp;

public interface CourseCompRep extends CrudRepository<AvhCourseComp, String>{

	public List<AvhCourseComp> findByCourse(AvhCourse course);
}
