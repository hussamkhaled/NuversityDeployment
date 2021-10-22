package avh.nuversity.digid.services.impl.rep;


import org.springframework.data.repository.CrudRepository;

import avh.nuversity.digid.model.AvhNuidsequesncenumber;

public interface NuidSequencenumberRep extends CrudRepository<AvhNuidsequesncenumber, String>{
	public AvhNuidsequesncenumber findByGroupe(String groupe);
}
