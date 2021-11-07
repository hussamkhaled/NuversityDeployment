package avh.nuversity.lms.services.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import avh.nuversity.lms.model.AvhDepartment;
import avh.nuversity.lms.services.impl.query.CreateDepartmentQuery;
import avh.nuversity.lms.services.impl.rep.AvhRep;

@Component
public class DepartmentControllerImpl {
	@Autowired
	private AvhRep rep;

	public AvhDepartment createDepartment(CreateDepartmentQuery fc) {
		AvhDepartment dep = new AvhDepartment();
		
		dep.setIid(UUID.randomUUID().toString());
		dep.setName(fc.getName());
		dep.setFacultyBean(rep.getFacultyRep().findByIid(fc.getFaculty()));
		dep.setDirector(fc.getDirector());
		rep.getDepartmentRep().save(dep);
		
		return dep;
	}
}
