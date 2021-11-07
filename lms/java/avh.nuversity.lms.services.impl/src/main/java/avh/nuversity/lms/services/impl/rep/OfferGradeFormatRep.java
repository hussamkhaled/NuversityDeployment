package avh.nuversity.lms.services.impl.rep;

import org.springframework.data.repository.CrudRepository;

import avh.nuversity.lms.model.AvhOfferGradeFormat;

public interface OfferGradeFormatRep extends CrudRepository<AvhOfferGradeFormat, String>{

//	public AvhOfferGradeFormat findById(String id);
	
public AvhOfferGradeFormat findByIid(String iid);
}
	