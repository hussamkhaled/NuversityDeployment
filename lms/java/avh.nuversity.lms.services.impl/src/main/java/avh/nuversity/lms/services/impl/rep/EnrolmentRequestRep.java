package avh.nuversity.lms.services.impl.rep;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import avh.nuversity.lms.model.AvhEnrolmentRequest;
import avh.nuversity.lms.model.AvhStudent;

@Repository
public interface EnrolmentRequestRep extends CrudRepository<AvhEnrolmentRequest,String>{

	public List<AvhEnrolmentRequest> findByStudentBean(AvhStudent studentBean);
	public AvhEnrolmentRequest findByIid(String iid);
	public List<AvhEnrolmentRequest> findByStatus(String status);
}
