package avh.nuversity.lms.services.impl.rep;

import org.springframework.data.repository.CrudRepository;

import avh.nuversity.lms.model.AvhUniversity;

public interface UniversityRep extends CrudRepository<AvhUniversity, String>{

	public AvhUniversity findByIid(String iid);
}
