package avh.nuversity.digid.services.impl.rep;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import avh.nuversity.digid.model.AvhUser;
import avh.nuversity.digid.model.AvhUsergroup;

@Repository
public interface UserGroupsRep extends CrudRepository<AvhUsergroup, String> {

	public AvhUsergroup findByAuser(AvhUser auser);
}
