package avh.nuversity.lms.services.impl.rep;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import avh.nuversity.lms.model.AvhDepartment;
import avh.nuversity.lms.model.AvhFaculty;


public interface DepartmentRep extends CrudRepository<AvhDepartment, String>{

	public AvhDepartment findByIid(String iid);
	public List<AvhDepartment> findByFacultyBean(AvhFaculty facultyBean);
}
