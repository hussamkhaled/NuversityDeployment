package avh.nuversity.lms.services.impl.rep;

import org.springframework.data.repository.CrudRepository;

import avh.nuversity.lms.model.AvhCampus;


public interface CampusRep extends CrudRepository<AvhCampus, String>{

	public AvhCampus findByIid(String iid);
	public Iterable<AvhCampus> findAll();
}
