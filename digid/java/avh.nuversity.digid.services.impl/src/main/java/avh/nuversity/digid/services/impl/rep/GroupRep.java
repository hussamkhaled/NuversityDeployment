package avh.nuversity.digid.services.impl.rep;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import avh.nuversity.digid.model.AvhGroup;

@Repository
public interface GroupRep extends CrudRepository<AvhGroup, String> {

}
