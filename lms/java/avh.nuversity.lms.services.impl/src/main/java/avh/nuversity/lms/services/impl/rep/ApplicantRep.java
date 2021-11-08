package avh.nuversity.lms.services.impl.rep;

import org.springframework.data.repository.CrudRepository;

import avh.nuversity.lms.model.AvhApplicant;

public interface ApplicantRep extends CrudRepository<AvhApplicant, String>{

public AvhApplicant findByIid(String iid);
public AvhApplicant findByUserid(String userid);
}
