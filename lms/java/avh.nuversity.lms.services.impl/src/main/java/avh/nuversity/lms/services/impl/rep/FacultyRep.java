package avh.nuversity.lms.services.impl.rep;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import avh.nuversity.lms.model.AvhFaculty;


public interface FacultyRep extends CrudRepository<AvhFaculty, String>{

	public AvhFaculty findByIid(String iid);
	public List<AvhFaculty> findAll();
	
}
