package avh.nuversity.lms.services.impl.rep;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import avh.nuversity.lms.model.AvhApplicant;
import avh.nuversity.lms.model.AvhApplication;

public interface ApplicationRep extends CrudRepository<AvhApplication, String>{

	public AvhApplication findByIid(String iid);
	public AvhApplication findByApplicantBean(AvhApplicant applicantBean);
	public List<AvhApplication> findByStatus(String status);
	
}
