package avh.nuversity.lms.services.impl.rep;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import avh.nuversity.lms.model.AvhMajor;
import avh.nuversity.lms.model.AvhMajorReqDoc;

public interface MajorReqDocRep extends CrudRepository<AvhMajorReqDoc, String>{

	
	
//	public List<AvhMajorReqDoc> findByMajorBean(AvhMajor major);
	
}
