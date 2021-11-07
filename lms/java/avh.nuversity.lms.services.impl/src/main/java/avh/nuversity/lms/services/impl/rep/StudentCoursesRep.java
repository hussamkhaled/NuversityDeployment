package avh.nuversity.lms.services.impl.rep;




import java.util.List;

import org.springframework.data.repository.CrudRepository;

import avh.nuversity.lms.model.AvhStudentCourses;

public interface StudentCoursesRep extends CrudRepository<AvhStudentCourses, String>{
	
	public List<AvhStudentCourses> findByStudentmajorid(String studentmajorid);
  
}
