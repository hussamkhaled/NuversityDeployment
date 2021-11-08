package avh.nuversity.lms.services.impl.rep;

import org.springframework.data.repository.CrudRepository;

import avh.nuversity.lms.model.AvhSemester;

public interface SemesterRep extends CrudRepository<AvhSemester, String>{

	public AvhSemester findByIid(String iid);
	
	public Iterable<AvhSemester> findAll();
	
}
