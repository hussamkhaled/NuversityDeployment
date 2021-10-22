package avh.nuversity.lms.services.impl.rep;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import avh.nuversity.lms.model.AvhCourseOffering;

public interface CourseOfferingRep extends CrudRepository<AvhCourseOffering, String>{

	public AvhCourseOffering findByIid(String iid);
	public List<AvhCourseOffering> findAll();
}
