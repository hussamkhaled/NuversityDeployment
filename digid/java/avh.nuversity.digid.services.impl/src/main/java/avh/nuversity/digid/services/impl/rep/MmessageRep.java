package avh.nuversity.digid.services.impl.rep;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import avh.nuversity.digid.model.AvhMmesage;

@Repository
public interface MmessageRep extends CrudRepository<AvhMmesage, String>{

}
