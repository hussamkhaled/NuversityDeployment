package avh.nuversity.lms.services.impl.rep;



import org.springframework.data.repository.CrudRepository;

import avh.nuversity.lms.model.AvhGlobalGpa;

public interface GlobalGpaRep extends CrudRepository<AvhGlobalGpa, String>{
	
	public AvhGlobalGpa findByStudentmajorid(String studentmajorid);

	
}
