package avh.nuversity.digid.services.impl.rep;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import avh.nuversity.digid.model.AvhContact;
import avh.nuversity.digid.model.AvhCredentials;
import avh.nuversity.digid.model.AvhUser;

@Repository
public interface UserRep extends CrudRepository<AvhUser, String> {
	public AvhUser findByUserid(String userId);
	public AvhUser findByNumail(String numail);
	public AvhUser findByContact(AvhContact contact);
	public AvhUser findByAcredential(AvhCredentials acredential);
}
