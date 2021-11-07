package avh.nuversity.lms.services.impl.rep;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import avh.nuversity.lms.model.AvhPgm;


public interface ProgramRep extends CrudRepository<AvhPgm, String>{

	public AvhPgm findByIid(String iid);
	public List<AvhPgm> findAll();

}
