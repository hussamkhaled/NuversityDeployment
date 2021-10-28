package avh.nuversity.lms.services.impl.rep;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import avh.nuversity.lms.model.AvhOfferGradeLine;

public interface OfferGradeLineRep extends CrudRepository<AvhOfferGradeLine, String>{

	Optional<AvhOfferGradeLine> findById(String id);
	
}
