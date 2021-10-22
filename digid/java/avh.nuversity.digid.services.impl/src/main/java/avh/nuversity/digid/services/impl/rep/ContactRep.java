package avh.nuversity.digid.services.impl.rep;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import avh.nuversity.digid.model.AvhContact;

@Repository
public interface ContactRep extends CrudRepository<AvhContact, String> {
	AvhContact findByEmail(String email);
}