package avh.nuversity.digid.services.impl.rep;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import avh.nuversity.digid.model.AvhPendingRequest;


@Repository
public interface PendingRequestRep extends CrudRepository<AvhPendingRequest, String>{
	public AvhPendingRequest findByRlink(String rlink);
	
}
