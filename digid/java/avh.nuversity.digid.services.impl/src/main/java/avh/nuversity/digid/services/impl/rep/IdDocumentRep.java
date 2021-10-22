package avh.nuversity.digid.services.impl.rep;

import org.springframework.data.repository.CrudRepository;

import avh.nuversity.digid.model.AvhIddocument;


public interface IdDocumentRep extends CrudRepository<AvhIddocument, String>{
	public AvhIddocument findByCid(String cid);
}
