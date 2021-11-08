package avh.nuversity.lms.services.impl.rep;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import avh.nuversity.lms.model.AvhMajor;
import avh.nuversity.lms.model.AvhMajorCourse;

public interface MajorCourseRep extends CrudRepository<AvhMajorCourse, String>{

	public List<AvhMajorCourse> findByMajorBean(AvhMajor majorBean);
//	public AvhMajorCourse findByCourseAndMjor(AvhCourse courseBean,AvhMajor majorBean);
	
	
}
