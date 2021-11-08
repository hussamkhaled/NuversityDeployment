package avh.nuversity.lms.services.impl.rep;

import org.springframework.data.repository.CrudRepository;

import avh.nuversity.lms.model.AvhCourse;


public interface CourseRep extends CrudRepository<AvhCourse, String>{

	public AvhCourse findByIid(String iid);
}
